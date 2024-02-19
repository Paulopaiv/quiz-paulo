package com.paulo.company.dto;

import com.paulo.company.model.QuestionSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSessionDTO {


    private Long id;
    private Boolean activeSession;
    private Long punctuation;
    private Long userId;
    private String level;
    private List<QuestionSession> questionSessionList = new ArrayList<>();



}

