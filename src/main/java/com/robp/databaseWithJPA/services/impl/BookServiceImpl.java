package com.robp.databaseWithJPA.services.impl;

import com.robp.databaseWithJPA.domain.entities.BookEntity;
import com.robp.databaseWithJPA.repositories.BookRepository;
import com.robp.databaseWithJPA.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
