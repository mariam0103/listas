package co.com.sofka.crud.servicio;


import co.com.sofka.crud.entidad.TodoPadre;
import co.com.sofka.crud.repositorio.TodoPadreRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoPadreServicio {

    @Autowired
    private TodoPadreRepositorio repositorio;

    public Iterable<TodoPadre> ListarTodoPadre (){
        return repositorio.findAll();
    }

    public TodoPadre guardarTodoPadre(TodoPadre todo){
        return repositorio.save(todo);
    }

    public void eliminarTodoPadre(Long id){
        repositorio.deleteById(id);
    }
}
