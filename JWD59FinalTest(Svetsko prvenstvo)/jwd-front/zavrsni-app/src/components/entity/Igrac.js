import React from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import ZavrsniAxios from "../../apis/ZavrsniAxios";


class Igrac extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            igraci: []
        }
    }
    addToReprezentacijaB(utakmica) {
        var params = {
            'id': utakmica.id,
            'reprezentacijaAId': utakmica.reprezentacijaA.id,
            'reprezentacijaBId': utakmica.reprezentacijaB.id,
            'brojGolovaA': utakmica.reprezentacijaA.id,
            'brojGolovaB': utakmica.reprezentacijaB.id
        }
        console.log(params)

        ZavrsniAxios.put("/utakmice/" + utakmica.id, params)
            .then((res) => {
                this.getUtakmice()
                this.props.navigate("/utakmice")
                window.location.reload(true);
            })
            .catch((err => {
                alert("Neuspesna nabavka")
                this.props.navigate("/utakmice")
                console.log(err)
            }));
    }
    onInputChange(event) {
        const name = event.target.name;
        const value = event.target.value

        let igraci = this.state.search;
        igraci[name] = value;

        this.setState({ igraci })
    }
    render() {
        return (
            <div>
                <Row>
                    <Col xs="12" sm="10" md="8">
                        <h1 style={{ color: "purple" }}>Strelac gola</h1>
                        <Form>
                            <Form.Group>
                                <Form.Label>Strelac</Form.Label>
                                <Form.Select name="igtacId" onChange={(e) => this.onInputChange(e)}>
                                    <option value={null}></option>
                                    {this.state.igraci.map((igrac) => {
                                        return (
                                            <option value={igrac.id} key={igrac.id}>{igrac.naziv}</option>
                                        );
                                    })}
                                </Form.Select>
                            </Form.Group>
                            <Button style={{ marginTop: "25px" }} onClick={this.create}>
                                Dodajte gol
                            </Button>
                        </Form>
                    </Col>
                </Row>
            </div>
        )
    }
}

export default Igrac