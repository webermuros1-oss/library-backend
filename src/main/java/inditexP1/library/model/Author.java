package inditexP1.library.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

private String name;
private String surname;
private String nationality;
private Integer birthYear;
private Boolean alive;


    public Author(String name, String surname, String nationality, Integer birthYear, Boolean alive) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.birthYear = birthYear;
        this.alive = alive;
    }

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
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
