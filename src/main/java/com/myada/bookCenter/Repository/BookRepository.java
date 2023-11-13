package com.myada.bookCenter.Repository;

import com.myada.bookCenter.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
