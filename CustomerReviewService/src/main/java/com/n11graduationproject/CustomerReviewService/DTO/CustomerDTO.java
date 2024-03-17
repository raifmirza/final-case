package com.n11graduationproject.CustomerReviewService.DTO;

import com.n11graduationproject.CustomerReviewService.Entity.Coordinate;
import com.n11graduationproject.CustomerReviewService.Enum.Status;

public record CustomerDTO(String name, String surname,String email, Coordinate coordinate, Status status) {
}
