package com.paulo.company.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "tb_sessao_jogador_seq", allocationSize = 1)
@Entity
@Table(name = "tb_sessao_jogador")
public class PlayerSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_sessao_jogador_seq")

    @Column(name = "id")
    private Long id;

    @Column(name = "sessao_ativa")
    private Boolean activeSession;

    @Column(name = "pontuacao")
    private Long punctuation;

    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "level")
    private String level;

    @OneToMany(mappedBy = "playerSession", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<QuestionSession> questionSession = new ArrayList<>();


    public PlayerSession() {
    }

    public PlayerSession(Long id, Boolean activeSession, Long punctuation, Long userId, String level, List<QuestionSession> questionSession) {
        this.id = id;
        this.activeSession = activeSession;
        this.punctuation = punctuation;
        this.userId = userId;
        this.level = level;
        this.questionSession = questionSession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActiveSession() {
        return activeSession;
    }

    public void setActiveSession(Boolean activeSession) {
        this.activeSession = activeSession;
    }

    public Long getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Long punctuation) {
        this.punctuation = punctuation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<QuestionSession> getQuestionSession() {
        return questionSession;
    }

    public void setQuestionSession(List<QuestionSession> questionSession) {
        this.questionSession = questionSession;
    }

    @Override
    public String toString() {
        return "PlayerSession{" +
                "id=" + id +
                ", activeSession=" + activeSession +
                ", punctuation=" + punctuation +
                ", userId=" + userId +
                ", level='" + level + '\'' +
                ", questionSession=" + questionSession +
                '}';
    }


    public static final class Builder {
        private PlayerSession playerSession;

        private Builder() {
            playerSession = new PlayerSession();
        }

        public static Builder aPlayerSession() {
            return new Builder();
        }

        public Builder id(Long id) {
            playerSession.setId(id);
            return this;
        }

        public Builder activeSession(Boolean activeSession) {
            playerSession.setActiveSession(activeSession);
            return this;
        }

        public Builder punctuation(Long punctuation) {
            playerSession.setPunctuation(punctuation);
            return this;
        }

        public Builder userId(Long userId) {
            playerSession.setUserId(userId);
            return this;
        }

        public Builder level(String level) {
            playerSession.setLevel(level);
            return this;
        }

        public Builder questionSession(List<QuestionSession> questionSession) {
            playerSession.setQuestionSession(questionSession);
            return this;
        }

        public PlayerSession build() {
            return playerSession;
        }
    }
}
