package com.robp.databaseWithJPA.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data // annotation lombok che crea equals, hashcode, toString, getter e setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="author_id_seq")
    private Long id;
    private String name;
    private Integer age;
}