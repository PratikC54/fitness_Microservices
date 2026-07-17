package com.fitness.aiservice.controller;

import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.service.RecommenationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommenationService recommenationService;

    @GetMapping("/user/{userId}")
    private ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId){
        return ResponseEntity.ok(recommenationService.getUserRecommendation(userId));
    }

    @GetMapping("/activity/{activityId}")
    private ResponseEntity<Recommendation> getUserRecommenation(@PathVariable String activityId){
        return ResponseEntity.ok(recommenationService.getActivityRecommendation(activityId));

    }


}
