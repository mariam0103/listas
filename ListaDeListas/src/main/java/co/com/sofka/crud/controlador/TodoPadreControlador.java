package co.com.sofka.crud.controlador;
import co.com.sofka.crud.entidad.TodoPadre;
import co.com.sofka.crud.servicio.TodoPadreServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:3000")
public class TodoPadreControlador {

    @Autowired
    private TodoPadreServicio servicio;

    @GetMapping(value = "api/TodoPadres")
    public Iterable<TodoPadre> listar(){
        return servicio.ListarTodoPadre();
    }

    @PostMapping(value = "api/TodoPadres")
    public TodoPadre guardar (@RequestBody TodoPadre todoPadre){
        return servicio.guardarTodoPadre(todoPadre);
    }

    @DeleteMapping(value = "api/{id}/TodoPadres")
    public void eliminar(@PathVariable("id") Long id){
        servicio.eliminarTodoPadre(id);
    }

}
