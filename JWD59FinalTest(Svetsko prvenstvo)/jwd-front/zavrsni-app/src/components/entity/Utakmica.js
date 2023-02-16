import React from "react";
import { Button, Col, Form, Row, Table } from "react-bootstrap";
import ZavrsniAxios from "../../apis/ZavrsniAxios";

class Utakmica extends React.Component {

    constructor(props) {
        super(props);

        const search = {
            reprezentacijaAId: null,
            reprezentacijaBId: null,
        }

        this.state = {
            utakmice: [],
            reprezentacije: [],
            number: 0,
            pageNo: 0,
            totalPages: 1,
            search: search
        }
    }

    componentDidMount() {
        this.getUtakmice(0);
        this.getreprezentacije();
    }

    getUtakmice(newPageNo) {
        let config = {
            params: {
                reprezentacijaAId: this.state.search.reprezentacijaAId,
                reprezentacijaBId: this.state.search.reprezentacijaBId,
                pageNo: newPageNo
            }
        }

        ZavrsniAxios.get('/utakmice', config)
            .then(res => {
                console.log(res);
                this.setState({
                    utakmice: res.data,
                    pageNo: newPageNo,
                    totalPages: res.headers['total-pages']
                });
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Error occured please try again!');
            });
    }

    getreprezentacije() {
        ZavrsniAxios.get("/reprezentacije")
            .then((response) => {
                this.setState({ reprezentacije: response.data });
            })
            .catch((err => { console.log(err) }));
    }

    deleteFromState(utakmicaId) {
        var utakmice = this.state.utakmice;
        utakmice.forEach((element, index) => {
            if (element.id === utakmicaId) {
                utakmice.splice(index, 1);
                this.setState({ utakmice: utakmice });
                window.location.reload();
            }
        });
    }

    delete(utakmicaId) {
        ZavrsniAxios.delete('/utakmice/' + utakmicaId)
            .then(res => {
                // handle success
                console.log(res);
                alert('Utakmica was deleted successfully!');
                this.deleteFromState(utakmicaId); // ili refresh page-a window.location.reload();
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Error occured please try again!');
            });
    }

    onInputChange(event) {
        const name = event.target.name;
        const value = event.target.value

        let search = this.state.search;
        search[name] = value;

        this.setState({ search })
    }

    goToAdd() {
        this.props.navigate('/utakmice/add');
    }

    onNumberChange(event) {
        console.log(event.target.value);

        const { name, value } = event.target;
        console.log(name + ", " + value);

        this.setState((state, props) => ({
            number: value
        }));
    }

    addToReprezentacijaA(utakmica) {
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
    // clickReprezentacijaB() {
    // addToReprezentacijaB();


    // }
    renderUtakmice() {
        return this.state.utakmice.map((utakmica) => {
            const admin = window.localStorage['role'] == 'ROLE_ADMIN';
            if (admin) {
                return (
                    <tr key={utakmica.id}>
                        <td>{utakmica.reprezentacijaA.naziv}</td>
                        <td>{utakmica.reprezentacijaB.naziv}</td>
                        <td>{utakmica.brojGolovaA}</td>
                        <td>{utakmica.brojGolovaB}</td>
                        <td><Button variant="success" onClick={() => this.addToReprezentacijaA()}>A+1</Button></td>
                        <td><Button variant="success" onClick={() => this.addToReprezentacijaB()}>B+1</Button></td>
                        <td><Button variant="danger"
                            onClick={() => this.delete(utakmica.id)}>Delete</Button></td>

                    </tr>
                )
            }
        })
    }

    renderSearchForm() {
        return (
            <>
                <Form style={{ width: "100%" }}>
                    <Row><Col>
                        <Form.Group>
                            <Form.Label>Reprezentacija A</Form.Label>
                            <Form.Control name="reprezentacijaAId" value={this.state.search.reprezentacijaId} as="select" onChange={(e) => this.onInputChange(e)}>
                                <option value={null}></option>
                                {this.state.reprezentacije.map((reprezentacija) => {
                                    return (
                                        <option value={reprezentacija.id} key={reprezentacija.id}>{reprezentacija.naziv}</option>
                                    );
                                })}
                            </Form.Control>
                        </Form.Group>
                    </Col></Row>

                    <Row><Col>
                        <Form.Group>
                            <Form.Label>Reprezentacija B</Form.Label>
                            <Form.Control name="reprezentacijaBId" value={this.state.search.reprezentacijaId} as="select" onChange={(e) => this.onInputChange(e)}>
                                <option value={null}></option>
                                {this.state.reprezentacije.map((reprezentacija) => {
                                    return (
                                        <option value={reprezentacija.id} key={reprezentacija.id}>{reprezentacija.naziv}</option>
                                    );
                                })}
                            </Form.Control>
                        </Form.Group>
                    </Col></Row>

                </Form>
                <Row><Col>
                    <Button className="mt-3" onClick={() => this.getUtakmice(0)}>Pretraga</Button>
                </Col></Row>
            </>
        );
    }
    render() {
        return (
            <Col>
                <Row><h1 style={{ color: "purple" }}>Utakmice</h1></Row>

                <Row>
                    {this.renderSearchForm()}
                </Row>
                <br />

                <Row>
                    <Col style={{ display: 'flex', justifyContent: 'right' }}>
                        <Button disabled={this.state.pageNo === 0}
                            onClick={() => this.getUtakmice(this.state.pageNo - 1)}
                            className="mr-3">Prev</Button>
                        <Button disabled={this.state.pageNo === this.state.totalPages - 1}
                            onClick={() => this.getUtakmice(this.state.pageNo + 1)}>Next</Button>
                    </Col>
                </Row>

                <Row><Col>
                    <Table style={{ marginTop: 5 }}>
                        <thead>
                            <tr>
                                <th>Reprezentacija A</th>
                                <th>Reprezentacija B</th>
                                <th>Broj golova A</th>
                                <th>Broj golova B</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.renderUtakmice()}
                        </tbody>
                    </Table>
                </Col></Row>

            </Col>
        );
    }

}

export default Utakmica