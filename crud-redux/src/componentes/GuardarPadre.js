import React, { Component } from 'react';

class GuardarPadre extends Component {
render() {
return (
<div>
  <h4>Crear Padre</h4>
  <form>
   <input type="text" placeholder="Tarea padre,principal" />
    <button>Guardar</button>
  </form>
</div>
);
}
}
export default GuardarPadre;