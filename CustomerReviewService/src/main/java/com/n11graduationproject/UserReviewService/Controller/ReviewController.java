package com.n11graduationproject.UserReviewService.Controller;

import com.n11graduationproject.UserReviewService.Controller.Contract.ReviewControllerContract;
import com.n11graduationproject.UserReviewService.DTO.ReviewDTO;
import com.n11graduationproject.UserReviewService.General.RestResponse;
import com.n11graduationproject.UserReviewService.Request.ReviewSaveRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewControllerContract contract;

    @PostMapping
    public ResponseEntity<RestResponse<ReviewDTO>> save(@RequestBody @Valid ReviewSaveRequest reviewSaveRequest){
        ReviewDTO reviewDTO = contract.save(reviewSaveRequest);
        return ResponseEntity.ok(RestResponse.of(reviewDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> delete(@PathVariable Long id){
        contract.delete(id);
        RestResponse<String> response = RestResponse.of(null);
        response.setMessages("Review deleted successfully.");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update-review-{id}")
    public ResponseEntity<RestResponse<ReviewDTO>> updateReview(@PathVariable Long id, @RequestBody @NotBlank String review){
        ReviewDTO reviewDTO = contract.updateReview(id, review);
        RestResponse<ReviewDTO> response = RestResponse.of(reviewDTO);
        response.setMessages("Review text updated successfully.");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update-score-{id}")
    public ResponseEntity<RestResponse<ReviewDTO>> updateScore(@PathVariable Long id, @RequestBody @Max(5)@Min(1) int score){
        ReviewDTO reviewDTO = contract.updateScore(id, score);
        RestResponse<ReviewDTO> response = RestResponse.of(reviewDTO);
        response.setMessages("Review score updated successfully.");
        return ResponseEntity.ok(response);
    }
}
