package com.robp.databaseWithJPA;


import com.robp.databaseWithJPA.domain.Author;
import com.robp.databaseWithJPA.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Mario Rossi")
                .age(40)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Francesco Bianchi")
                .age(60)
                .build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("1235-56-6642-122")
                .title("Il signore degli anelli")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("4631-56-6642-122")
                .title("Il signore degli anelli - Le due torri")
                .author(author)
                .build();
    }
}