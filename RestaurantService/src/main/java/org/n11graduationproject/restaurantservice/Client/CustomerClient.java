package org.n11graduationproject.restaurantservice.Client;

import org.n11graduationproject.restaurantservice.DTO.ReviewDTO;
import org.n11graduationproject.restaurantservice.General.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value ="customer",url= "http://localhost:8080/api/v1")
public interface CustomerClient {

    @GetMapping("/reviews")
    public ResponseEntity<RestResponse<List<ReviewDTO>>> getReviewByRestaurantId(@RequestParam Long restaurantId);
}
