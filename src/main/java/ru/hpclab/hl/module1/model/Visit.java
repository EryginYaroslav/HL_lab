package com.example.fitnesstracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(optional = false)
    @JoinColumn(name = "training_id")
    private Training training;

    private LocalDate visitDate;
    private int caloriesBurned;

    public Visit() {
    }

    public Visit(Client client, Training training, LocalDate visitDate, int caloriesBurned) {
        this.client = client;
        this.training = training;
        this.visitDate = visitDate;
        this.caloriesBurned = caloriesBurned;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Training getTraining() {
        return training;
    }
    public void setTraining(Training training) {
        this.training = training;
    }
    public LocalDate getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }
    public int getCaloriesBurned() {
        return caloriesBurned;
    }
    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", client=" + client +
                ", training=" + training +
                ", visitDate=" + visitDate +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
