package com.n11graduationproject.CustomerReviewService.DTO;


public record ReviewDTO(String customerName,String customerSurname,Long restaurantId, String comment, int score) {
}
