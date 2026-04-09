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


}
