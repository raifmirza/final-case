package com.n11graduationproject.UserReviewService.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Coordinate {
    private double latitude;
    private double longitude;
}
