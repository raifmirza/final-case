package com.n11graduationproject.UserReviewService.Request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public record CustomerSaveRequest(@Length(max = 50,min = 1) @NotBlank(message = "Name can not be empty.") String name,
                                  @Length(max = 50) @NotBlank(message = "Surname can not be empty.")String surname,
                                  @Email @NotBlank(message = "Email can not be empty.")String email,
                                  @NotNull
                                  @DecimalMax(value = "90.000000",message = "Latitude can be max 90.000000")
                                  @DecimalMin(value = "-90.000000",message = "Latitude must be at least -90.000000") double latitude,
                                  @NotNull
                                  @DecimalMax(value = "180.000000",message = "Longitude can be max 180.000000")
                                  @DecimalMin(value = "-180.000000",message = "Longitude must be at least -90.000000")double longitude) {
}
