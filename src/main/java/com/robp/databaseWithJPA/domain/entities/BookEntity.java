package com.robp.databaseWithJPA.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    private String isbn;
    private String title;

    /*Il parametro cascade specifica l'operazione di cascata che deve essere applicata ai record figlio quando
      si verifica una certa operazione sul record padre.
      cascade = CascadeType.ALL specifica che tutte le operazioni di cascata devono essere applicate, comprese
      l'inserimento, l'aggiornamento e la rimozione.
     */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;
}
