package com.paulo.company.service;

import com.paulo.company.builder.QuestionMapper;
import com.paulo.company.dto.QuestionDTO;
import com.paulo.company.model.Question;
import com.paulo.company.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;

    public QuestionDTO saveQuestion(QuestionDTO questionDto) throws Exception {
        Long newQuestionId = null;
        if (Objects.nonNull(questionDto.getId())) {
            newQuestionId = questionDto.getId();
            if (questionRepository.existsById(newQuestionId)) {
                throw new Exception();
            } else {
                return questionMapper.toDTO(questionRepository.save(questionMapper.toEntity(questionDto)));
            }

        } else {
            return questionMapper.toDTO(questionRepository.save(questionMapper.toEntity(questionDto)));
        }
    }

    public void deleteQuestion(QuestionDTO questionDTO){
        questionRepository.delete(questionMapper.toEntity(questionDTO));
    }

    public QuestionDTO findById(Long id) throws Exception {
        return questionMapper.toDTO(questionRepository.findById(id).orElseThrow(Exception::new));
    }

}
