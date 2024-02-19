package com.paulo.company.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_sessao_questao")
public class QuestionSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;

    @Column(name = "foi_jogado")
    private Boolean wasPlayed;

    @Column(name = "jogador_venceu")
    private Boolean playerWon;

    @Column(name = "questao_ativa")
    private Boolean activeQuestion;

    @ManyToOne
    @JoinColumn(name = "sessao_jogador_id")
    private PlayerSession playerSession;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Question question;


    public QuestionSession() {
    }

    public QuestionSession(Long id, Boolean wasPlayed, Boolean playerWon, Boolean activeQuestion, PlayerSession playerSession, Question question) {
        this.id = id;
        this.wasPlayed = wasPlayed;
        this.playerWon = playerWon;
        this.activeQuestion = activeQuestion;
        this.playerSession = playerSession;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getWasPlayed() {
        return wasPlayed;
    }

    public void setWasPlayed(Boolean wasPlayed) {
        this.wasPlayed = wasPlayed;
    }

    public Boolean getPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(Boolean playerWon) {
        this.playerWon = playerWon;
    }

    public Boolean getActiveQuestion() {
        return activeQuestion;
    }

    public void setActiveQuestion(Boolean activeQuestion) {
        this.activeQuestion = activeQuestion;
    }

    public PlayerSession getPlayerSession() {
        return playerSession;
    }

    public void setPlayerSession(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionSession{" +
                "id=" + id +
                ", wasPlayed=" + wasPlayed +
                ", playerWon=" + playerWon +
                ", activeQuestion=" + activeQuestion +
                ", playerSession=" + playerSession +
                ", question=" + question +
                '}';
    }


    public static final class Builder {
        private QuestionSession questionSession;

        private Builder() {
            questionSession = new QuestionSession();
        }

        public static Builder aQuestionSession() {
            return new Builder();
        }

        public Builder id(Long id) {
            questionSession.setId(id);
            return this;
        }

        public Builder wasPlayed(Boolean wasPlayed) {
            questionSession.setWasPlayed(wasPlayed);
            return this;
        }

        public Builder playerWon(Boolean playerWon) {
            questionSession.setPlayerWon(playerWon);
            return this;
        }

        public Builder activeQuestion(Boolean activeQuestion) {
            questionSession.setActiveQuestion(activeQuestion);
            return this;
        }

        public Builder playerSession(PlayerSession playerSession) {
            questionSession.setPlayerSession(playerSession);
            return this;
        }

        public Builder question(Question question) {
            questionSession.setQuestion(question);
            return this;
        }

        public QuestionSession build() {
            return questionSession;
        }
    }
}

