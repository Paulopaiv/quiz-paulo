package com.paulo.company.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_tema")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id;
    @Column(name = "tema")
    private String theme;




    public Theme() {
    }

    public Theme(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                '}';
    }


    public static final class Builder {
        private Theme theme;

        private Builder() {
            theme = new Theme();
        }

        public static Builder aTheme() {
            return new Builder();
        }

        public Builder id(Long id) {
            theme.setId(id);
            return this;
        }

        public Builder theme(String theme) {
            this.theme.setTheme(theme);
            return this;
        }

        public Theme build() {
            return theme;
        }
    }
}
