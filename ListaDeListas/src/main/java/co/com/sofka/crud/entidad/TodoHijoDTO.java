package co.com.sofka.crud.entidad;

public class TodoHijoDTO {

    private Long idPadre;

    private Long id;
    private String name;
    private Boolean isCompleted;

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id; }

    public String getName() {return name;}

    public void setName(String name) {this.name = name; }

    public Boolean getCompleted() {return isCompleted; }

    public void setCompleted(Boolean completed) {isCompleted = completed; }

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }
}
