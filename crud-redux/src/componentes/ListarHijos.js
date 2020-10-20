import React, { Component } from 'react';

class ListarHijos extends Component {

    constructor(props) {
        super(props)
        this.state = { listaHijos: [] }
 }
 
 //Se ejecuta cuando se inicia el componente
 componentWillMount() {
     fetch("http://localhost:8080/api/"+this.props.idPadre+"/TodoHijos")
             .then(response => response.json())
             .then((listaHijos) => {
                 this.setState({ listaHijos : listaHijos })
     })
 }

render() {
    return (
        <div>
            <table>
                <tr>
                    <td>ID</td>
                    <td>NOMBRE</td>
                    <td> COMPLETADO </td>
                </tr>
                {this.state.listaHijos.map((hijo) => {
                    return<tr>
                            <td>{hijo.id}</td>
                            <td>{hijo.name}</td>
                            <td> false </td>
                        </tr>
                })}
            </table>
        </div>
        );
    }
}
export default ListarHijos;