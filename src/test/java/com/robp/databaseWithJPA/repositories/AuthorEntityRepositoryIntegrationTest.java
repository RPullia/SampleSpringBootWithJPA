package com.robp.databaseWithJPA.repositories;

import com.robp.databaseWithJPA.TestDataUtil;
import com.robp.databaseWithJPA.domain.entities.AuthorEntity;
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
public class AuthorEntityRepositoryIntegrationTest {

    private AuthorRepository underTest;

    // Autowired segnala a Spring la necessità di fare injection dei parametri forniti al costruttore
    @Autowired
    public AuthorEntityRepositoryIntegrationTest(AuthorRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);
    }

    @Test
    public void testThatMultipleAuthorCanBeCreatedAndRecalled(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntityA);

        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();
        underTest.save(authorEntityB);

        List<AuthorEntity> results = (List<AuthorEntity>) underTest.findAll();
        assertThat(results).hasSize(2);
        assertThat(results).containsExactly(authorEntityA, authorEntityB);

    }

    @Test
    public void testThatAuthorCanBeUpdated(){
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntity);
        authorEntity.setName("Tizio");

        underTest.save(authorEntity);
        Optional<AuthorEntity> result = underTest.findById(authorEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorEntity);


    }

    @Test
    public void testThatAuthorCanBeDeleted(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntityA);
        underTest.delete(authorEntityA);
        Optional<AuthorEntity> result = underTest.findById(authorEntityA.getId());
        assertThat(result).isEmpty();
    }

    @Test
    public void testGetAuthorWithAgeLessThan(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntityA);

        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();
        underTest.save(authorEntityB);

        Iterable <AuthorEntity> result = underTest.ageLessThan(50);
        assertThat(result).containsExactly(authorEntityA);
    }

    /*@Test
    public void testGetAuthorWithAgeGreaterThan(){
        AuthorEntity authorEntityA = TestDataUtil.createTestAuthorA();
        underTest.save(authorEntityA);

        AuthorEntity authorEntityB = TestDataUtil.createTestAuthorB();
        underTest.save(authorEntityB);

        Iterable <AuthorEntity> result = underTest.findAuthorWithAgeGreaterThan(50);
        assertThat(result).containsExactly(authorEntityB);
    }*/
}