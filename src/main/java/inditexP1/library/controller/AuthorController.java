package inditexP1.library.controller;


import inditexP1.library.model.Author;
import inditexP1.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    //GET /api/authors

    @GetMapping
    public List<Author> GetAllAuthors(){
        return authorService.getAllAuthors();
    }

    //GET api/authors/1

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int id) {
        Optional<Author> author = authorService.getAllAuthorById(id);
        if (author.isPresent()) {
            return ResponseEntity.ok(author.get());
        } else {
            return ResponseEntity.notFound().build();
        }



    }
    //DELETE api/authors/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        Optional<Author> author = authorService.getAllAuthorById(id);
        if (author.isPresent()){authorService.deleteAuthor(id);
            return  ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
