package com.paulo.company.service;



import com.paulo.company.dto.ThemeDTO;
import com.paulo.company.model.Theme;
import com.paulo.company.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public ThemeDTO onSave(Theme themeDTO){
        Theme theme = themeRepository.save(new Theme(themeDTO.getTheme(), themeDTO.getId()));
        return new ThemeDTO(theme.getTheme(), theme.getId());
    }

    public void onDelete(ThemeDTO themeDTO){
        themeRepository.deleteById(themeDTO.getId());
    }

    public List<ThemeDTO> onListTheme(){
        return themeRepository.findAll().stream()
                .map(theme -> new ThemeDTO(theme.getTheme(), theme.getId()))
                .collect(Collectors.toList());
    }

    public Optional<ThemeDTO> findTheme(Long id){
        return themeRepository.findById(id)
                .map(theme -> new ThemeDTO(theme.getTheme(), theme.getId()));
    }
}
