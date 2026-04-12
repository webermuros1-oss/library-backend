package inditexP1.library.controller;


import inditexP1.library.model.Author;
import inditexP1.library.repository.AuthorRepository;
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



    @GetMapping
    public List<Author> GetAllAuthors(){
        return authorService.getAllAuthors();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Author> GetAuthorById(@PathVariable int id) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()) {
            return ResponseEntity.ok(author.get());
        } else {
            return ResponseEntity.notFound().build();
        }



    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()){authorService.deleteAuthor(id);
            return  ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{category}")
    public List<Author> getAuthorsByCategory(@PathVariable String category) {
        return authorService.getAuthorsByCategory(category);
    }


    @PutMapping("/{id}")
    public boolean editAuthor(@PathVariable Integer id, @RequestBody Author autor){
        return authorService.editAuthor(id, autor);
    }


    @PostMapping("/new")
    public Author saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }
}
