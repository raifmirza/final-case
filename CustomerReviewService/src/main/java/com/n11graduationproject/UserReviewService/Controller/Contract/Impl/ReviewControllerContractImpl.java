package com.n11graduationproject.UserReviewService.Controller.Contract.Impl;

import com.n11graduationproject.UserReviewService.Controller.Contract.ReviewControllerContract;
import com.n11graduationproject.UserReviewService.DTO.ReviewDTO;
import com.n11graduationproject.UserReviewService.Entity.Review;
import com.n11graduationproject.UserReviewService.Enum.Score;
import com.n11graduationproject.UserReviewService.Mapper.ReviewMapper;
import com.n11graduationproject.UserReviewService.Request.ReviewSaveRequest;
import com.n11graduationproject.UserReviewService.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewControllerContractImpl implements ReviewControllerContract {
    private final ReviewService service;
    @Override
    public ReviewDTO save(ReviewSaveRequest reviewSaveRequest) {
        Review review = ReviewMapper.INSTANCE.convertToEntity(reviewSaveRequest);
        review = service.save(review);
        return ReviewMapper.INSTANCE.convertToDTO(review);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public ReviewDTO updateComment(Long id,String comment) {
        Review review = service.findById(id);
        review.setComment(comment);
        review =service.save(review);
        return ReviewMapper.INSTANCE.convertToDTO(review);
    }

    @Override
    public ReviewDTO updateScore(Long id,int score) {
        Review review = service.findById(id);
        review.setScore(Score.fromValue(score));
        review =service.save(review);
        return ReviewMapper.INSTANCE.convertToDTO(review);
    }
}
