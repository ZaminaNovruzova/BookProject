package com.myada.bookCenter.Manager;

import com.myada.bookCenter.entity.Book;
import com.myada.bookCenter.Repository.BookRepository;
import com.myada.bookCenter.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookManager implements BookService {
    private final BookRepository bookRepository;


    @Override
    public ResponseEntity<Book> createBook(Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok(book);
    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @Override
    public ResponseEntity<Optional<Book>> getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (id != null) {
            return ResponseEntity.ok(book);
        } else
            return ResponseEntity.notFound().build();
    }


    @Override
    public ResponseEntity<Book> updateBook(Long id, Book updatedBook) {

        if (id != null) {
            Book book = bookRepository.getById(id);
            book.setId(updatedBook.getId());
            book.setName(updatedBook.getName());
            book.setAuthor(updatedBook.getAuthor());
            book.setTitle(updatedBook.getTitle());
            return (ResponseEntity<Book>) ResponseEntity.ok();
        } else return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        if (id != null) {
            bookRepository.deleteById(id);
            return (ResponseEntity<Void>) ResponseEntity.ok();
        } else
            return ResponseEntity.notFound().build();

    }

}