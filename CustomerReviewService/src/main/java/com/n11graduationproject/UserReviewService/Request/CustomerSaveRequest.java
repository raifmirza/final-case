package com.n11graduationproject.UserReviewService.Request;

import com.n11graduationproject.UserReviewService.Entity.Coordinate;

public record CustomerSaveRequest(String name, String surname, String email, Coordinate coordinate) {
}
