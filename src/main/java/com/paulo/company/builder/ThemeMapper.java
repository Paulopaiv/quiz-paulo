package com.paulo.company.builder;

import com.paulo.company.dto.ThemeDTO;
import com.paulo.company.model.Theme;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ThemeMapper {

    private final ModelMapper modelMapper;

    private final QuestionMapper questionMapper;

    public ThemeMapper(ModelMapper modelMapper, QuestionMapper questionMapper) {
        this.modelMapper = modelMapper;
        this.questionMapper = questionMapper;
    }

    public ThemeDTO toDTO(Theme theme) {
        return modelMapper.map(theme, ThemeDTO.class);
    }

//    public ThemeDTO toDTO(Theme theme) {
//        ThemeDTO dto = modelMapper.map(theme, ThemeDTO.class);
//        dto.setQuestionList(questionMapper.toListDTO(theme.getQuestions()));
//        return dto;
//    }

    public Theme toEntity(ThemeDTO themeDTO) {
        return modelMapper.map(themeDTO, Theme.class);

    }

    public List<ThemeDTO> toListDTO(List<Theme> themeList) {
        List<ThemeDTO> listReturn = new ArrayList<>();
        for (Theme i : themeList) {
            listReturn.add(toDTO(i));
        }
        return listReturn;
    }

    public List<Theme> toList(List<ThemeDTO> temaList) {
        List<Theme> listReturn = new ArrayList<>();
        for (ThemeDTO i : temaList) {
            listReturn.add(toEntity(i));
        }
        return listReturn;
    }

}