package com.example.fitnesstracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private int age;

    @Column(name = "subscription_end_date")
    private LocalDate subscriptionEndDate;

    public Client() {
    }

    public Client(String fullName, int age, LocalDate subscriptionEndDate) {
        this.fullName = fullName;
        this.age = age;
        this.subscriptionEndDate = subscriptionEndDate;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public LocalDate getSubscriptionEndDate() {
        return subscriptionEndDate;
    }
    public void setSubscriptionEndDate(LocalDate subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", subscriptionEndDate=" + subscriptionEndDate +
                '}';
    }
}
