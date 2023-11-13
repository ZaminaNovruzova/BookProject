package com.myada.bookCenter.Service;

import com.myada.bookCenter.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    //CRUD
    ResponseEntity<Book> createBook(Book book);

    List<Book> getAllBooks();

    ResponseEntity<Optional<Book>> getById(Long id);

    ResponseEntity<Book> updateBook(Long id, Book updatedBook);

    ResponseEntity<Void> deleteById(Long id);


}
