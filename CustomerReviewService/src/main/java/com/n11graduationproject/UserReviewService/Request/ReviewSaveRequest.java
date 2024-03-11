package com.n11graduationproject.UserReviewService.Request;


public record ReviewSaveRequest(Long customerID, String comment, int score) {
}
