package com.paulo.company.dto;

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
    private Question question;



}
