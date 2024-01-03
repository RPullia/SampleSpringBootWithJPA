package com.robp.databaseWithJPA.repositories;

import com.robp.databaseWithJPA.domain.Author;
import com.robp.databaseWithJPA.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
