package com.n11graduationproject.UserReviewService.Controller.Contract;

import com.n11graduationproject.UserReviewService.DTO.ReviewDTO;
import com.n11graduationproject.UserReviewService.Request.ReviewSaveRequest;

public interface ReviewControllerContract {
    public ReviewDTO save(ReviewSaveRequest reviewSaveRequest);

    public void delete(Long id);
    public ReviewDTO updateComment(Long id,String comment);
    public ReviewDTO updateScore(Long id,int score);
}
