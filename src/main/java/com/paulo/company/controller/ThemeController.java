package com.paulo.company.controller;

import com.paulo.company.dto.ThemeDTO;
import com.paulo.company.model.Theme;
import com.paulo.company.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @PostMapping
    public ResponseEntity<ThemeDTO> createTheme(@RequestBody Theme theme) {
        return ResponseEntity.status(HttpStatus.CREATED).body(themeService.onSave(theme));
    }

    @GetMapping
    public ResponseEntity<List<ThemeDTO>> getAllThemes() {
        return ResponseEntity.ok(themeService.onListTheme());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThemeDTO> getThemeById(@PathVariable("id") Long id) {
        return themeService.findTheme(id)
                .map(theme -> ResponseEntity.ok(theme))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable("id") Long id) {
        return themeService.findTheme(id)
                .map(theme -> {
                    themeService.onDelete(theme);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
