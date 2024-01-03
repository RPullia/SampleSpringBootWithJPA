package com.robp.databaseWithJPA.repositories;

import com.robp.databaseWithJPA.TestDataUtil;
import com.robp.databaseWithJPA.domain.entities.AuthorEntity;
import com.robp.databaseWithJPA.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookEntityIntegrationTest {

    private BookRepository underTest;

    private AuthorRepository authorRepository;

    @Autowired
    public BookEntityIntegrationTest(BookRepository underTest, AuthorRepository authorRepository){
        this.underTest = underTest;
        this.authorRepository = authorRepository;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){

        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();

        BookEntity book = TestDataUtil.createTestBookA(authorEntity);
        underTest.save(book);
        Optional<BookEntity> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);

    }
}