package com.myada.bookCenter.Controller;

import com.myada.bookCenter.entity.Book;
import com.myada.bookCenter.Manager.BookManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")

@RequiredArgsConstructor
public class BookController {
    private final BookManager bookManager;

    @PostMapping(value = "/{book}")
    public ResponseEntity<Book> createBooks(@RequestBody Book book) {
        return bookManager.createBook(book);
    }

    @GetMapping(value = "/books")
    List<Book> getAllBookss() {
        return bookManager.getAllBooks();
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Optional<Book>> getByIds(@PathVariable Long id) {
        return bookManager.getById(id);
    }

    @PutMapping(value = "/updatedBook")
    ResponseEntity<Book> updateBookss(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookManager.updateBook(id, updatedBook);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteByIds(@PathVariable Long id) {
        return bookManager.deleteById(id);
    }


}
