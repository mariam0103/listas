package co.com.sofka.crud.entidad;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TodoPadre {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<TodoHijo> todoHijos;

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id; }

    public String getName() {return name;}

    public void setName(String name) {this.name = name; }

    public Set<TodoHijo> getTodoHijos() {
        return todoHijos;
    }

    public void setTodoHijos(Set<TodoHijo> todoHijos) {
        this.todoHijos = todoHijos;
    }
}
