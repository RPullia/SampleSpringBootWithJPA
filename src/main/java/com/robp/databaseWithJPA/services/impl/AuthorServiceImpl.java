package com.robp.databaseWithJPA.services.impl;

import com.robp.databaseWithJPA.domain.entities.AuthorEntity;
import com.robp.databaseWithJPA.repositories.AuthorRepository;
import com.robp.databaseWithJPA.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository= authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
