import React from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import ZavrsniAxios from "../../apis/ZavrsniAxios";

class DodajUtakmicu extends React.Component {

    constructor(props) {
        super(props);

        let utakmice = {
            brojGolovaA: 0,
            brojGolovaB: 0,
            reprezentacijaAId: null,
            reprezentacijaBId: null
        };

        this.state = { utakmice: utakmice, reprezentacije: [] };
        this.create = this.create.bind(this);

    }

    componentDidMount() {
        this.getData();
    }
    getData() {
        this.getReprezentacije();
    }

    async getReprezentacije() {
        await ZavrsniAxios.get("/reprezentacije")
            .then((response) => {
                this.setState({ reprezentacije: response.data });
            })
            .catch((err => { console.log(err); alert("Nesto ne valja") }));
    }

    // async getWineries() {
    //     ZavrsniAxios.get("/wineries")
    //         .then((response) => {
    //             this.setState({ wineries: response.data });
    //         })
    //         .catch((err => { console.log(err) }));
    // }

    async create() {

        let params = {
            'reprezentacijaAId': { id: this.state.utakmica.reprezentacijaA.id },
            'reprezentacijaBId': { id: this.state.utakmica.reprezentacijaB.id },
            'brojGolovaA': this.state.brojGolovaA.id,
            'brojGolovaB': this.state.brojGolovaB.id
        };

        await ZavrsniAxios.post("/utakmice", params)
            .then((res) => {
                // handle success
                console.log(res);

                alert("Utakmica was added successfully!");
                this.props.navigate("/utakmice");
            })
            .catch((error) => {
                // handle error
                console.log(error);
                alert("Error occured please try again!");
            });
    }

    onInputChange(event) {
        const name = event.target.name;
        const value = event.target.value;

        console.log(value)

        let utakmice = this.state.utakmice;
        utakmice[name] = value;

        this.setState({ utakmice })
    }


    render() {
        return (
            <>
                <Row>
                    <Col></Col>
                    <Col xs="12" sm="10" md="8">
                        <h1 style={{ color: "purple" }}>Dodavanje utakmice</h1>
                        <Form>

                            <Form.Group>
                                <Form.Label>Reprezentacija A</Form.Label>
                                <Form.Select name="reprezentacijaAId" onChange={(e) => this.onInputChange(e)}>
                                    <option value={null}></option>
                                    {this.state.reprezentacije.map((reprezentacija) => {
                                        return (
                                            <option value={reprezentacija.id} key={reprezentacija.id}>{reprezentacija.naziv}</option>
                                        );
                                    })}
                                </Form.Select>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Reprezentacija B</Form.Label>
                                <Form.Select name="reprezentacijaBId" onChange={(e) => this.onInputChange(e)}>
                                    <option value={null}></option>
                                    {this.state.reprezentacije.map((reprezentacija) => {
                                        return (
                                            <option value={reprezentacija.id} key={reprezentacija.id}>{reprezentacija.naziv}</option>
                                        );
                                    })}
                                </Form.Select>
                            </Form.Group>

                            <Button style={{ marginTop: "25px" }} onClick={this.create}>
                                Dodaj utakmicu
                            </Button>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </>
        );
    }

}

export default DodajUtakmicu