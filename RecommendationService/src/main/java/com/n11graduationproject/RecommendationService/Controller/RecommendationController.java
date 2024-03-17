package com.n11graduationproject.RecommendationService.Controller;

import com.n11graduationproject.RecommendationService.Client.RestaurantClient;
import com.n11graduationproject.RecommendationService.DTO.RestaurantDTO;
import com.n11graduationproject.RecommendationService.General.RestResponse;
import com.n11graduationproject.RecommendationService.Service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService service;

    @GetMapping
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> getRecommendation(@RequestParam double Latitude,@RequestParam double Longitude){
        List<RestaurantDTO> restaurantDTOS = service.recommendRestaurants(Latitude, Longitude, 10);
        RestResponse<List<RestaurantDTO>> listRestResponse = RestResponse.of(restaurantDTOS);
        listRestResponse.setMessages("Recommended restaurants returned");
        return ResponseEntity.ok(listRestResponse);
    }
}
