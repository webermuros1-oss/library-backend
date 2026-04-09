package inditexP1.library.model;


import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String genre;
    private String publishYear;
    private Boolean available;

    public Book(int id, Boolean available, String publishYear, String genre, String title) {
        this.id = id;
        this.available = available;
        this.publishYear = publishYear;
        this.genre = genre;
        this.title = title;
    }

    public int getId() {
        return id;
    }



    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
