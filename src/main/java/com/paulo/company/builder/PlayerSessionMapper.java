package com.paulo.company.builder;

import com.paulo.company.dto.PlayerSessionDTO;
import com.paulo.company.model.PlayerSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerSessionMapper {

    private final ModelMapper modelMapper;


    public PlayerSessionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayerSessionDTO toDTO(PlayerSession model) {
        PlayerSessionDTO playerSessionDTO = modelMapper.map(model, PlayerSessionDTO.class);
        playerSessionDTO.setQuestionSessionList(model.getQuestionSession());
        return playerSessionDTO;
    }

    public PlayerSession toEntity(PlayerSessionDTO dto) {
        PlayerSession playerSession = modelMapper.map(dto, PlayerSession.class);
        playerSession.setQuestionSession(dto.getQuestionSessionList());
        return playerSession;
    }

    public List<PlayerSessionDTO> toListDTO(List<PlayerSession> modelList) {
        return modelList.stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public List<PlayerSession> toList(List<PlayerSessionDTO> dtosList) {
        return dtosList.stream()
                .map(this::toEntity).collect(Collectors.toList());
    }

}
