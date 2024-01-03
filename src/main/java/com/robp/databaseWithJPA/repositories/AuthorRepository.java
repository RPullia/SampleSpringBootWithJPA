package com.robp.databaseWithJPA.repositories;

import com.robp.databaseWithJPA.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> ageLessThan(int age);

    Iterable<Author> ageGreaterThan(int age);

    //o con HQL - Hibernate Query Language
    @Query("SELECT a FROM Author a WHERE a.age > ?1")
    Iterable<Author> findAuthorWithAgeGreaterThan(int age);

}
