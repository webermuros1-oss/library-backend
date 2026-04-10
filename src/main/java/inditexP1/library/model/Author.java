package inditexP1.library.model;


import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

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
private String category;


    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("author")
    private List<Book> books = new ArrayList<>();





    public Author(Boolean alive, Integer birthTear, String nationality, String surname, String name, Integer id) {
        this.alive = alive;
        this.birthYear = birthTear;
        this.nationality = nationality;
        this.surname = surname;
        this.name = name;
        this.id = id;
    }

    public Author() {
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

    public void setBirthYear(Integer birthTear) {
        this.birthYear = birthTear;
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

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
