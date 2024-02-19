package com.paulo.company.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_configuracao")
public class GameConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;
    @Column(name = "moedas")
    private Long coins;
    @Column(name = "pontos")
    private Long score;
    @Column(name = "level")
    private String level;


    public GameConfiguration() {
    }

    public GameConfiguration(Long id, Long coins, Long score, String level) {
        this.id = id;
        this.coins = coins;
        this.score = score;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoins() {
        return coins;
    }

    public void setCoins(Long coins) {
        this.coins = coins;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "GameConfiguration{" +
                "id=" + id +
                ", coins=" + coins +
                ", score=" + score +
                ", level='" + level + '\'' +
                '}';
    }


    public static final class Builder {
        private GameConfiguration gameConfiguration;

        private Builder() {
            gameConfiguration = new GameConfiguration();
        }

        public static Builder aGameConfiguration() {
            return new Builder();
        }

        public Builder id(Long id) {
            gameConfiguration.setId(id);
            return this;
        }

        public Builder coins(Long coins) {
            gameConfiguration.setCoins(coins);
            return this;
        }

        public Builder score(Long score) {
            gameConfiguration.setScore(score);
            return this;
        }

        public Builder level(String level) {
            gameConfiguration.setLevel(level);
            return this;
        }

        public GameConfiguration build() {
            return gameConfiguration;
        }
    }
}
