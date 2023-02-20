import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { HashRouter as Router, Link, Route, Routes } from "react-router-dom";
import { Button, Container, Nav, Navbar } from 'react-bootstrap';
import { logout } from './services/auth';
import NotFound from "./components/NotFound";
import Home from "./components/Home";
import Login from "./components/authorization/Login"
import Utakmica from './components/entity/Utakmica';
import Igrac from './components/entity/Igrac';
import DodajUtakmicu from './components/entity/DodajUtakmicu';

class App extends React.Component {
  // constructor(props) {
  //   super(props);

  //   this.state = {
  //     movieForEdit: {}
  //   }
  // }

  // editMovieSelected(movie) {
  //   this.setState({ movieForEdit: movie });
  // }

  render() {
    return (
      <>
        <Router>
          <Navbar bg="dark" variant="dark" expand>
            <Navbar.Brand as={Link} to="/">
              JWD
            </Navbar.Brand>
            <Nav className="mr-auto">
              <Nav.Link as={Link} to="/utakmice">
                Utakmica
              </Nav.Link>
              <Nav.Link as={Link} to="/utakmice/add">
                Dodaj utakmicu
              </Nav.Link>
            </Nav>

            {window.localStorage['jwt'] ?
              <Button onClick={() => logout()}>Log out</Button> :
              <Nav.Link as={Link} to="/login">Log in</Nav.Link>
            }
          </Navbar>

          <Container style={{ marginTop: 25 }}>
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/utakmice" element={<Utakmica />} />
              <Route path="/utakmice/edit/:id" element={<DodajUtakmicu />} />
              <Route path="/login" element={<Login />} />
              <Route path="*" element={<NotFound />} />
              <Route path="/utakmice/igrac" element={<Igrac />} />
            </Routes>
          </Container>
        </Router>
      </>
    );
  }
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);