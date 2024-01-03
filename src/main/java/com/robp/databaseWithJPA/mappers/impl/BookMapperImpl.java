package com.robp.databaseWithJPA.mappers.impl;

import com.robp.databaseWithJPA.domain.dto.AuthorDto;
import com.robp.databaseWithJPA.domain.dto.BookDto;
import com.robp.databaseWithJPA.domain.entities.AuthorEntity;
import com.robp.databaseWithJPA.domain.entities.BookEntity;
import com.robp.databaseWithJPA.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {

    private ModelMapper modelMapper;

    public  BookMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);

    }
}
