package com.paulo.company.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@SequenceGenerator(name = "tb_alternativa_seq", allocationSize = 1)
@Entity
@Table(name = "tb_alternativa")
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_alternativa_seq")

    @Column
    private Long id;
    @Column(name = "correta")
    private Boolean itsCorrect;

    @Column(name = "alternativa")
    private String alternative;
    @Column(name = "letra_referencia")
    private String referenceLetter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_question")
    private Question question;

    public Alternative() {
    }

    public Alternative(Long id, Boolean itsCorrect, String alternative, String referenceLetter, Question question) {
        this.id = id;
        this.itsCorrect = itsCorrect;
        this.alternative = alternative;
        this.referenceLetter = referenceLetter;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getItsCorrect() {
        return itsCorrect;
    }

    public void setItsCorrect(Boolean itsCorrect) {
        this.itsCorrect = itsCorrect;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getReferenceLetter() {
        return referenceLetter;
    }

    public void setReferenceLetter(String referenceLetter) {
        this.referenceLetter = referenceLetter;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Alternative{" +
                "id=" + id +
                ", itsCorrect=" + itsCorrect +
                ", alternative='" + alternative + '\'' +
                ", referenceLetter='" + referenceLetter + '\'' +
                ", question=" + question +
                '}';
    }


    public static final class Builder {
        private Alternative alternative;

        private Builder() {
            alternative = new Alternative();
        }

        public static Builder anAlternative() {
            return new Builder();
        }

        public Builder id(Long id) {
            alternative.setId(id);
            return this;
        }

        public Builder itsCorrect(Boolean itsCorrect) {
            alternative.setItsCorrect(itsCorrect);
            return this;
        }

        public Builder alternative(String alternativeBuilder) {
            alternative.setAlternative(alternativeBuilder);
            return this;
        }


        public Builder referenceLetter(String referenceLetter) {
            alternative.setReferenceLetter(referenceLetter);
            return this;
        }

        public Builder question(Question question) {
            alternative.setQuestion(question);
            return this;
        }

        public Alternative build() {
            return alternative;
        }
    }
}
