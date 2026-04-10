package inditexP1.library.services;


import inditexP1.library.model.Book;
import inditexP1.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //GET todos

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Get ID

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }



    // DELETE

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }


    // PUT

    public Optional<Book> updateBook(int id, Book updatedBook) {
        Optional<Book> existing = bookRepository.findById(id);
        if (existing.isPresent()) {
            updatedBook.setId(id);
            return Optional.of(bookRepository.save(updatedBook));
        }
        return Optional.empty();
    }


    //POST

    public Book saveBook(Book book) {
            return bookRepository.save(book);
        }


        public List<Book> getBooksByCategory(String category) {
            return bookRepository.findByCategory(category);
        }




    }