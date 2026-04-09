package inditexP1.library.services;


import inditexP1.library.model.Author;
import inditexP1.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    //GET todos
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    //GET por ID

    public Optional<Author> getAuthorById(int id){
        return authorRepository.findById(id);
    }

    //DELETE

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }


}
