package com.paulo.company.controller;

import com.paulo.company.dto.AlternativeDTO;
import com.paulo.company.service.AlternativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternative")
public class AlternativeController {

    @Autowired
    private AlternativeService alternativeService;


    @GetMapping
    public ResponseEntity<List<AlternativeDTO>> findAllAlternatives(){
        return new ResponseEntity<>(alternativeService.getAllAlternatives(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlternativeDTO> findAllAlternativeById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(alternativeService.getAlternativeById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AlternativeDTO> saveAlternative(@RequestBody AlternativeDTO alternativeDTO) {
        return new ResponseEntity<>(alternativeService.saveAlternative(alternativeDTO), HttpStatus.CREATED);
    }






}
