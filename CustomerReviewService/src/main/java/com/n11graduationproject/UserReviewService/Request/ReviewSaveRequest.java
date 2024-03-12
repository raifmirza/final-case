package com.n11graduationproject.UserReviewService.Request;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record ReviewSaveRequest(@NotBlank Long customerID,@NotBlank Long resturantId, @NotBlank @Length(max = 500,min = 10,message = "Comment must be between 10 to 500 characters.") String comment, @Min
                               (value = 1,message = "Score must be at least 1.")@Max(value = 5,message = "Score can be max 5.") int score) {
}
