package inditexP1.library.model;


import jakarta.persistence.*;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;
private String surname;
private String nationality;
private Integer birthTear;
private Boolean alive;




    public Author(Boolean alive, Integer birthTear, String nationality, String surname, String name, int id) {
        this.alive = alive;
        this.birthTear = birthTear;
        this.nationality = nationality;
        this.surname = surname;
        this.name = name;
        this.id = id;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Integer getBirthTear() {
        return birthTear;
    }

    public void setBirthTear(Integer birthTear) {
        this.birthTear = birthTear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
