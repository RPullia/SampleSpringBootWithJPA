package com.robp.databaseWithJPA.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* I DTO - Data transfer Object consentono di introdurre un livello di mapping tra lo strato di presentazione e quelli
   di servizio e  persistenza, nascondendo al primo ciò che avviene negli altri.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private Long id;

    private String name;

    private Integer age;
}
