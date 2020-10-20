package co.com.sofka.crud.repositorio;

import co.com.sofka.crud.entidad.TodoHijo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoHijoRepositorio  extends CrudRepository<TodoHijo, Long> {
}
