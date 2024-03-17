package com.n11graduationproject.UserReviewService.Request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record CoordinateUpdateRequest(@NotNull
                                      @DecimalMax(value = "90.000000",message = "Latitude can be max 90.000000")
                                      @DecimalMin(value = "-90.000000",message = "Latitude must be at least -90.000000") double latitude,
                                      @NotNull
                                      @DecimalMax(value = "180.000000",message = "Longitude can be max 180.000000")
                                      @DecimalMin(value = "-180.000000",message = "Longitude must be at least -90.000000")double longitude) {
}
