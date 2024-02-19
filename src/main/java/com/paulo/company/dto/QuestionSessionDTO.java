package com.paulo.company.dto;


import com.paulo.company.model.PlayerSession;
import com.paulo.company.model.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSessionDTO {


    private Long id;
    private Boolean wasPlayed;
    private Boolean playerWon;
    private Boolean activeQuestion;
    private PlayerSession playerSession;
    private Question question;



}

