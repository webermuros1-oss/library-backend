package inditexP1.library.services;

import inditexP1.library.model.Author;
import inditexP1.library.model.Book;
import inditexP1.library.repository.AuthorRepository;
import inditexP1.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService{
    AuthorRepository authorRepository;
    BookRepository bookRepository;
 //put

  //post
   public boolean addAuthor(Author author){
       int searchedId = author.getId();
       if(authorRepository.findById(searchedId).isPresent()) return false;
       authorRepository.save(author);
       return true;
   }

    public boolean addBook(Book book){
        int searchedId = book.getId();
        if(bookRepository.findById(searchedId).isPresent()) return false;
        bookRepository.save(book);
        return true;
    }
}
