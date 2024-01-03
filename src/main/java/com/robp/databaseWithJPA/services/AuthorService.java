package com.robp.databaseWithJPA.services;

import com.robp.databaseWithJPA.domain.entities.AuthorEntity;

public interface AuthorService {

    AuthorEntity createAuthor(AuthorEntity authorEntity);
}
