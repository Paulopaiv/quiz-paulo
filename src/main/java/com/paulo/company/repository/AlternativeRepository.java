package com.paulo.company.repository;

import com.paulo.company.model.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlternativeRepository extends JpaRepository<Alternative, Long> {

    List<Alternative> findByQuestionId(Long questionId);
    Optional<Alternative> findQuestionById(Long id);

    Optional<Alternative> findByQuestionIdAndItsCorrect(Long questionId, Boolean itsCorrect);


}
