package org.n11graduationproject.restaurantservice.DTO;

import java.util.List;

public record RestaurantDTOWithReviews(String name, String type, double score,double latitude,double longitude, List<ReviewDTO> reviewDTOList) {

}
