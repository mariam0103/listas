package co.com.sofka.crud.controlador;

import co.com.sofka.crud.entidad.TodoHijo;
import co.com.sofka.crud.entidad.TodoHijoDTO;
import co.com.sofka.crud.servicio.TodoHijoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class TodoHijoControlador {

    @Autowired
    private TodoHijoServicio servicio;
    //listar hijos de un padre en especifico enviando el id en la url
    @GetMapping(value = "api/{idPadre}/TodoHijos")
    public Iterable<TodoHijo> listarHijos(@PathVariable("idPadre") Long idPadre){
        return servicio.ListarTodoHijo(idPadre);
    }

    //guarda un hijo de un padre, el id del padre viene en el dto
    @PostMapping(value = "api/TodoHijos")
    public TodoHijoDTO guardar (@RequestBody TodoHijoDTO todoHijoDTO){

        return servicio.guardarTodoHijo(todoHijoDTO);
    }

    //actualizar un hijo
    @PutMapping(value = "api/TodoHijos")
    public TodoHijo actualizar(@RequestBody TodoHijo todoHijo){
        return servicio.actualizarTodoHijo(todoHijo);
    }

    @DeleteMapping(value = "api/{id}/TodoHijos")
        public void eliminar(@PathVariable("id") Long id){
            servicio.eliminarTodoHijo(id);
    }

}
