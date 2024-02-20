package com.paulo.company.service;


import com.paulo.company.builder.ThemeMapper;
import com.paulo.company.dto.ThemeDTO;
import com.paulo.company.model.Theme;
import com.paulo.company.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private ThemeMapper themeMapper;

    public ThemeDTO onSave(ThemeDTO themeDTO) {
        return themeMapper.toDTO(themeRepository.save(themeMapper.toEntity(themeDTO)));
    }

    public void onDelete(ThemeDTO theme) {
        Optional<Theme> optionalTheme = themeRepository.findById(theme.getId());
        if (optionalTheme.isPresent()) {
            themeRepository.delete(themeMapper.toEntity(theme));
        }
    }

    public List<ThemeDTO> onListTheme() {
        return themeMapper.toListDTO(themeRepository.findAll());
    }

    public ThemeDTO findTheme(Long id) {
        Optional<Theme> optionalTheme = themeRepository.findById(id);
        return themeMapper.toDTO(optionalTheme.get());
    }
}