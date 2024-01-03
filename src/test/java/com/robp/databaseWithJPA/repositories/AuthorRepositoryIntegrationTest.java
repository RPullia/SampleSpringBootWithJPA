package com.robp.databaseWithJPA.repositories;

import com.robp.databaseWithJPA.TestDataUtil;
import com.robp.databaseWithJPA.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) //Evita test pollution dovuta alla creazione multipla ad esempio degli author
public class AuthorRepositoryIntegrationTest {

    private AuthorRepository underTest;

    // Autowired segnala a Spring la necessità di fare injection dei parametri forniti al costruttore
    @Autowired
    public AuthorRepositoryIntegrationTest(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorCanBeCreatedAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);

        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);

        List<Author> results = (List<Author>) underTest.findAll();
        assertThat(results).hasSize(2);
        assertThat(results).containsExactly(authorA, authorB);

    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        Author author  = TestDataUtil.createTestAuthorA();
        underTest.save(author);
        author.setName("Tizio");

        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);


    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);
        underTest.delete(authorA);
        Optional<Author> result = underTest.findById(authorA.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testGetAuthorWithAgeLessThan(){
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);

        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);

        Iterable <Author> result = underTest.ageLessThan(50);
        assertThat(result).containsExactly(authorA);
    }

    @Test
    public void testGetAuthorWithAgeGreaterThan(){
        Author authorA = TestDataUtil.createTestAuthorA();
        underTest.save(authorA);

        Author authorB = TestDataUtil.createTestAuthorB();
        underTest.save(authorB);

        Iterable <Author> result = underTest.findAuthorWithAgeGreaterThan(50);
        assertThat(result).containsExactly(authorB);
    }
}