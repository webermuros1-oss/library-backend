package inditexP1.library.model;


import jakarta.persistence.*;

import java.security.PrivateKey;

@Entity
@Table(name="books")

public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String title;
    private String isbn;
    private String yearPublication;
    private String image;


    @ManyToOne
    @JoinColumn(name = Authors_id)

    public Books(int id, String title, String isbn, String yearPublication, String image) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.yearPublication = yearPublication;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
