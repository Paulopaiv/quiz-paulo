package com.paulo.company.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_questao")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;
    @Column(name = "pergunta")
    private String question;

    @ManyToOne
    @JoinColumn (name = "id_tema")
    private Theme theme;

    public Question() {
    }

    public Question(Long id, String question, Theme theme) {
        this.id = id;
        this.question = question;
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
                ", theme=" + theme +
                '}';
    }


    public static final class Builder {
        private Question question;

        private Builder() {
            question = new Question();
        }

        public static Builder aQuestion() {
            return new Builder();
        }

        public Builder id(Long id) {
            question.setId(id);
            return this;
        }


        public Builder theme(Theme theme) {
            question.setTheme(theme);
            return this;
        }

        public Question build() {
            return question;
        }
    }
}
