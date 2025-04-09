package com.example.fitnesstracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;        // Например, "йога", "бег"
    private int duration;       // Длительность в минутах
    private String difficulty;  // Например, "легкая", "средняя", "сложная"

    public Training() {
    }

    public Training(String type, int duration, String difficulty) {
        this.type = type;
        this.duration = duration;
        this.difficulty = difficulty;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", duration=" + duration +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
