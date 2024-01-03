package com.robp.databaseWithJPA.services;

import com.robp.databaseWithJPA.domain.entities.BookEntity;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);
}
