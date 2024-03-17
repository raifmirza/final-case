package com.n11graduationproject.CustomerReviewService.Controller.Contract;

import com.n11graduationproject.CustomerReviewService.DTO.ReviewDTO;
import com.n11graduationproject.CustomerReviewService.Request.ReviewSaveRequest;

import java.util.List;

public interface ReviewControllerContract {
    public ReviewDTO save(ReviewSaveRequest reviewSaveRequest);

    public void delete(Long id);
    public ReviewDTO updateReview(Long id,String comment);
    public ReviewDTO updateScore(Long id,int score);
    public List<ReviewDTO> findByRestaurantId(Long id);
}
