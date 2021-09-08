package co.edu.unicauca.cor.domain;

import java.time.LocalDate;

/**
 * Reclamo del cliente por pedido insatisfecho
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Claim {

    private int id;
    private String title;
    private String description;
    private TypeEnum type;
    private LocalDate date;
    private boolean attended;

    public Claim(int id, String title, String description, TypeEnum type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.attended = false;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public LocalDate getDate() {
        return date;
    }

}
