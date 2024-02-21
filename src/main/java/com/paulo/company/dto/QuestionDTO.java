package com.paulo.company.dto;

import com.paulo.company.model.Theme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionDTO {

    private Long id;
    private Theme theme;
    private String question;
    private List<AlternativeDTO> alternativeList;

}
