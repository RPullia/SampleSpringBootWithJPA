package com.robp.databaseWithJPA;


import com.robp.databaseWithJPA.domain.entities.AuthorEntity;
import com.robp.databaseWithJPA.domain.entities.BookEntity;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static AuthorEntity createTestAuthorA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Mario Rossi")
                .age(40)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Francesco Bianchi")
                .age(60)
                .build();
    }

    public static BookEntity createTestBookA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("1235-56-6642-122")
                .title("Il signore degli anelli")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("4631-56-6642-122")
                .title("Il signore degli anelli - Le due torri")
                .authorEntity(authorEntity)
                .build();
    }
}