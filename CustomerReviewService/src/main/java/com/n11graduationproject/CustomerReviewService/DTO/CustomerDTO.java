package com.n11graduationproject.UserReviewService.DTO;

import com.n11graduationproject.UserReviewService.Entity.Coordinate;
import com.n11graduationproject.UserReviewService.Enum.Status;

public record CustomerDTO(String name, String surname,String email, Coordinate coordinate, Status status) {
}
