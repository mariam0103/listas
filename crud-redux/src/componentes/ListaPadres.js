
import GuardarHijos from './GuardarHijos';
import ListarHijos from './ListarHijos';
import React, {Component} from 'react';


class ListaPadres extends Component { 

constructor(props) {
       super(props)
       this.state = { listaPadres: [] }
}

//Se ejecuta cuando se inicia el componente
componentWillMount() {
    fetch("http://localhost:8080/api/TodoPadres")
            .then(response => response.json())
            .then((listaPadres) => {
                this.setState({ listaPadres : listaPadres })
    })
}

render() {
    return (
        <div>
            <ul>Lista de padres</ul>
            {this.state.listaPadres.map((padre) => {
                return<div>
                <h4> -------------{padre.name}------------</h4>
                <GuardarHijos/>
                <ListarHijos idPadre={padre.id}/>
                <br></br>
                </div> 
            })}
        </div>
        );
    }
}
export default ListaPadres;