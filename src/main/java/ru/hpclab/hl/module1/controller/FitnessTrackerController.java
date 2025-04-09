package com.example.fitnesstracker.controller;

import com.example.fitnesstracker.model.Client;
import com.example.fitnesstracker.model.Training;
import com.example.fitnesstracker.model.Visit;
import com.example.fitnesstracker.service.ClientService;
import com.example.fitnesstracker.service.RatingService;
import com.example.fitnesstracker.service.TrainingService;
import com.example.fitnesstracker.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FitnessTrackerController {

    private final ClientService clientService;
    private final TrainingService trainingService;
    private final VisitService visitService;
    private final RatingService ratingService;

    @Autowired
    public FitnessTrackerController(ClientService clientService, TrainingService trainingService,
                                    VisitService visitService, RatingService ratingService) {
        this.clientService = clientService;
        this.trainingService = trainingService;
        this.visitService = visitService;
        this.ratingService = ratingService;
    }

    // Endpoints для работы с клиентами
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        Optional<Client> client = clientService.getClient(id);
        return client.orElse(null);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    // Endpoints для работы с тренировками
    @PostMapping("/trainings")
    public Training createTraining(@RequestBody Training training) {
        return trainingService.createTraining(training);
    }

    @GetMapping("/trainings")
    public List<Training> getTrainings() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/trainings/{id}")
    public Training getTraining(@PathVariable Long id) {
        Optional<Training> training = trainingService.getTraining(id);
        return training.orElse(null);
    }

    @DeleteMapping("/trainings/{id}")
    public void deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
    }

    // Endpoints для работы с посещениями
    @PostMapping("/visits")
    public Visit createVisit(@RequestBody Visit visit) {
        return visitService.createVisit(visit);
    }

    @GetMapping("/visits")
    public List<Visit> getVisits() {
        return visitService.getAllVisits();
    }

    @GetMapping("/visits/{id}")
    public Visit getVisit(@PathVariable Long id) {
        Optional<Visit> visit = visitService.getVisit(id);
        return visit.orElse(null);
    }

    @DeleteMapping("/visits/{id}")
    public void deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
    }

    // Endpoint для вывода рейтинга активности за последний месяц
    @GetMapping("/rating")
    public List<RatingService.RatingEntry> getRating() {
        return ratingService.getMonthlyActivityRating();
    }
}
