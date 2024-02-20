package com.paulo.company.controller;

import com.paulo.company.dto.ThemeDTO;
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

    @PostMapping("/save")
    public ResponseEntity<ThemeDTO> createTheme(@RequestBody ThemeDTO themeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(themeService.onSave(themeDTO));
    }

    @GetMapping
    public ResponseEntity<List<ThemeDTO>> getAllThemes() {
        return ResponseEntity.ok(themeService.onListTheme());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ThemeDTO> getThemeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(themeService.findTheme(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable("id") Long id) {
        themeService.findTheme(id);
        return ResponseEntity.noContent().build();
    }
}
