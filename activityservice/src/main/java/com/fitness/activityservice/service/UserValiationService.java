package com.fitness.activityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserValiationService {
    private final WebClient userserviceWebclient;

    public boolean valiateUser(String userId) {
        try {
            return userserviceWebclient.get().uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
