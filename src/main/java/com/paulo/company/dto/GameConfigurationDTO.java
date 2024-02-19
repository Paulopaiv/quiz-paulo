package com.paulo.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameConfigurationDTO {

    private Long id;
    private Long coins;
    private Long score;
    private String level;



}
