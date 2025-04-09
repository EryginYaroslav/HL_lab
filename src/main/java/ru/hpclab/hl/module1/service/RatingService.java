package com.example.fitnesstracker.service;

import com.example.fitnesstracker.model.Client;
import com.example.fitnesstracker.model.Visit;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RatingService {

    private final VisitService visitService;

    public RatingService(VisitService visitService) {
        this.visitService = visitService;
    }

    // Метод для получения рейтинга активности клиентов за последний месяц
    public List<RatingEntry> getMonthlyActivityRating() {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        // Фильтрация посещений за последний месяц
        List<Visit> visits = visitService.getAllVisits().stream()
                .filter(visit -> visit.getVisitDate().isAfter(oneMonthAgo))
                .collect(Collectors.toList());

        // Подсчет суммарных калорий для каждого клиента
        Map<Client, Integer> caloriesByClient = new HashMap<>();
        for (Visit visit : visits) {
            caloriesByClient.merge(visit.getClient(), visit.getCaloriesBurned(), Integer::sum);
        }

        // Формирование и сортировка списка рейтинговых записей
        List<RatingEntry> rating = caloriesByClient.entrySet().stream()
                .map(entry -> new RatingEntry(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(RatingEntry::getCaloriesBurned).reversed())
                .collect(Collectors.toList());

        return rating;
    }

    public static class RatingEntry {
        private final Client client;
        private final int caloriesBurned;

        public RatingEntry(Client client, int caloriesBurned) {
            this.client = client;
            this.caloriesBurned = caloriesBurned;
        }

        public Client getClient() {
            return client;
        }

        public int getCaloriesBurned() {
            return caloriesBurned;
        }

        @Override
        public String toString() {
            return "RatingEntry{" +
                    "client=" + client +
                    ", caloriesBurned=" + caloriesBurned +
                    '}';
        }
    }
}
