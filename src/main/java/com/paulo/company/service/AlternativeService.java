package com.paulo.company.service;


import com.paulo.company.builder.AlternativeMapper;
import com.paulo.company.dto.AlternativeDTO;
import com.paulo.company.repository.AlternativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlternativeService {

    @Autowired
    AlternativeRepository alternativeRepository;

    @Autowired
    AlternativeMapper alternativeMapper;

    public AlternativeDTO getAlternativeById(Long id) throws Exception {
        return alternativeMapper.toDTO(alternativeRepository.findById(id).orElseThrow(Exception::new));
    }

    public List<AlternativeDTO> getAllAlternatives() {
        return alternativeMapper.toListDTO(alternativeRepository.findAll());
    }

    public AlternativeDTO saveAlternative(AlternativeDTO alternativeDTO){
        return alternativeMapper.toDTO(alternativeRepository.save(alternativeMapper.toEntity(alternativeDTO)));
    }

    public void deleteAlternative(Long id) throws Exception {
        alternativeRepository.delete(alternativeMapper.toEntity(getAlternativeById(id)));
    }








}
