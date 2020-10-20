package co.com.sofka.crud.servicio;

import co.com.sofka.crud.entidad.TodoHijo;
import co.com.sofka.crud.entidad.TodoHijoDTO;
import co.com.sofka.crud.entidad.TodoPadre;
import co.com.sofka.crud.repositorio.TodoHijoRepositorio;
import co.com.sofka.crud.repositorio.TodoPadreRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;


@Service
public class TodoHijoServicio {

    @Autowired
    private TodoHijoRepositorio repositorio;

    @Autowired
    private TodoPadreRepositorio repositorioPadre;

    public Iterable<TodoHijo>ListarTodoHijo(Long idPadre){
        var padre = repositorioPadre.findById(idPadre)
                .orElseThrow(() -> new RuntimeException("El padre no existe"));
        return padre.getTodoHijos();
    }

    public TodoHijoDTO guardarTodoHijo(TodoHijoDTO todoHijoDTO){
        //Encuentro a el padre con el id del padre que llega en el DTO
        var padre = repositorioPadre.findById(todoHijoDTO.getIdPadre())
                .orElseThrow(() -> new RuntimeException("El padre no existe"));

        //Convierto el DTO a TodoHijo por que JPA no me admite el dto si no el TodoHijo
        TodoHijo hijo = new TodoHijo();
        hijo.setId(todoHijoDTO.getId());
        hijo.setName(todoHijoDTO.getName());
        hijo.setCompleted(todoHijoDTO.getCompleted());

        //Se buscan los hijos y se añade el nuevo hijo
        padre.getTodoHijos().add(hijo);
        // Guarde el padre que fue al qe se le añadio el hijo
        var padreActualizado = repositorioPadre.save(padre);

        //Busca en la lista de hijos del padre actualizado cual fue el ultimo id guardado par asi saber con cual
        //Id me quedo el hijo
        var listaActualizadaDeHijos = padreActualizado.getTodoHijos()
                .stream()
                .max(Comparator.comparingInt(item -> item.getId().intValue()))
                .orElseThrow();
        todoHijoDTO.setId(listaActualizadaDeHijos.getId());
        todoHijoDTO.setIdPadre(todoHijoDTO.getIdPadre());
        return todoHijoDTO;
    }

    public TodoHijo actualizarTodoHijo(TodoHijo todoHijo){
        if(todoHijo.getId()!=null) {
            return repositorio.save(todoHijo);
        }
        throw new RuntimeException("No Existe el ID Para Actualizar");
    }

    public void eliminarTodoHijo(Long id){
         repositorio.deleteById(id);
    }

}
