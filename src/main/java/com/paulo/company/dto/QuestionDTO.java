package com.paulo.company.dto;


import com.paulo.company.model.Theme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {


    private Long id;
    private String question;
    private Theme theme;


}
