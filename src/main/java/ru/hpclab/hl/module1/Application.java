package com.example.fitnesstracker;

import com.example.fitnesstracker.model.Client;
import com.example.fitnesstracker.model.Training;
import com.example.fitnesstracker.model.Visit;
import com.example.fitnesstracker.repository.ClientRepository;
import com.example.fitnesstracker.repository.TrainingRepository;
import com.example.fitnesstracker.repository.VisitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadData(ClientRepository clientRepository,
                                      TrainingRepository trainingRepository,
                                      VisitRepository visitRepository) {
        return args -> {
            // Создаем клиентов
            Client client1 = new Client("Иван Иванов", 30, LocalDate.of(2025, 12, 31));
            Client client2 = new Client("Петр Петров", 25, LocalDate.of(2025, 10, 15));
            clientRepository.save(client1);
            clientRepository.save(client2);

            // Создаем тренировки
            Training training1 = new Training("бег", 30, "средняя");
            Training training2 = new Training("йога", 45, "легкая");
            trainingRepository.save(training1);
            trainingRepository.save(training2);

            // Создаем посещения (используем сегодняшнюю дату и даты в пределах последнего месяца)
            Visit visit1 = new Visit(client1, training1, LocalDate.now(), 300);
            Visit visit2 = new Visit(client2, training2, LocalDate.now().minusDays(10), 200);
            Visit visit3 = new Visit(client1, training2, LocalDate.now().minusDays(5), 250);
            visitRepository.save(visit1);
            visitRepository.save(visit2);
            visitRepository.save(visit3);
        };
    }
}
