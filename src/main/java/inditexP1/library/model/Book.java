package inditexP1.library.model;


import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String isbn;
    private Integer publicationYear;
    private String image;
    private String category;

    @ManyToOne
    @JsonIgnoreProperties("books")
    private Author author;



    public Book(String title, String isbn, Integer id, Integer publicationYear, String image, String category) {
        this.title = title;
        this.isbn = isbn;
        this.id = id;
        this.publicationYear = publicationYear;
        this.image = image;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
