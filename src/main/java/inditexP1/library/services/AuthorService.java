package inditexP1.library.services;


import inditexP1.library.model.Author;
import inditexP1.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    //GET todos
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    //GET por ID

    public Optional<Author> getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    //DELETE

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
    //Put
    public boolean editAuthor( int id, Author author){
            try {
                if (this.getAuthorById(id).isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author with that id not found in our DB");
                }
                Author authorEdit = this.getAuthorById(id).get();
                authorEdit.setName(author.getName());
                authorEdit.setNationality(author.getNationality());
                authorEdit.setAlive(author.getAlive());
                authorEdit.setSurname(author.getSurname());
                authorEdit.setBirthTear(author.getBirthTear());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: \n " + e.getMessage());
                }
            return true;
    }

    //Post
    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }


}