import React , { Component } from 'react';
import GuardarPadre from './componentes/GuardarPadre';
import ListaPadres from './componentes/ListaPadres';

class App extends Component {
  render() {
    return (
    <div className="App">
      <h1>Dashboard</h1>
      <GuardarPadre/> 
      <ListaPadres/>
    </div>
    );
    }
  }
export default App;
