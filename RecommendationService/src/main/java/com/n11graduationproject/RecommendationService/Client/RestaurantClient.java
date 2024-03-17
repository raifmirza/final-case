package com.n11graduationproject.RecommendationService.Client;

import com.n11graduationproject.RecommendationService.DTO.RestaurantDTO;
import com.n11graduationproject.RecommendationService.General.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "restaurant",url = "http://localhost:8081/api/v1/restaurants")
public interface RestaurantClient {

    @GetMapping("/getCloseRestaurants")
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> getClose(@RequestParam double Latitude,@RequestParam double Longitude,@RequestParam double Radius);
}
