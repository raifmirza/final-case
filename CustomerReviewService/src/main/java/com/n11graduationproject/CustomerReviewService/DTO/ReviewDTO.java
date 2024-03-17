package com.n11graduationproject.UserReviewService.DTO;


public record ReviewDTO(String customerName,String customerSurname,Long restaurantId, String comment, int score) {
}
