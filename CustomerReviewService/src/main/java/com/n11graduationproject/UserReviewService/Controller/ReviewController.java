package com.n11graduationproject.UserReviewService.Controller;

import com.n11graduationproject.UserReviewService.Controller.Contract.ReviewControllerContract;
import com.n11graduationproject.UserReviewService.DTO.ReviewDTO;
import com.n11graduationproject.UserReviewService.Request.ReviewSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewControllerContract contract;

    @PostMapping
    public ResponseEntity<ReviewDTO> save(@RequestBody ReviewSaveRequest reviewSaveRequest){
        ReviewDTO reviewDTO = contract.save(reviewSaveRequest);
        return ResponseEntity.ok(reviewDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        contract.delete(id);
        return ResponseEntity.ok("Review has deleted successfully.");
    }
}
