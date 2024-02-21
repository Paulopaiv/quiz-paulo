package com.paulo.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paulo.company.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlternativeDTO {


    private Long id;
    private Boolean itsCorrect;
    private String alternative;
    private String referenceLetter;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //private Question question;



}
