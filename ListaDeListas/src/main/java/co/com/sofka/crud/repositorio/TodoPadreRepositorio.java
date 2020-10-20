package co.com.sofka.crud.repositorio;

import co.com.sofka.crud.entidad.TodoPadre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoPadreRepositorio extends CrudRepository<TodoPadre, Long> {
}
