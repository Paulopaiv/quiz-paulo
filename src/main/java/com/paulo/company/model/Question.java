package com.paulo.company.model;

import jakarta.persistence.*;
import lombok.Builder;
import java.util.ArrayList;
import java.util.List;


@Builder
@SequenceGenerator(name = "tb_questao_seq", allocationSize = 1)
@Entity
@Table(name = "tb_questao")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_questao_seq")

    @Column
    private Long id;

    @Column(name = "pergunta")
    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Alternative> alternativeList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_tema")
    private Theme theme;

    public Question() {

    }

    public Question(Long id, String question, List<Alternative> alternativeList, Theme theme) {
        this.id = id;
        this.question = question;
        this.alternativeList = alternativeList;
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Alternative> getAlternativeList() {
        return alternativeList;
    }

    public void setAlternativeList(List<Alternative> alternativeList) {
        for (Alternative alternative:alternativeList){
            alternative.setQuestion(this);
        }
        this.alternativeList = alternativeList;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", alternativeList=" + alternativeList +
                ", theme=" + theme +
                '}';
    }

}
