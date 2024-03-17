package com.n11graduationproject.UserReviewService.Controller.Contract.Impl;

import com.n11graduationproject.UserReviewService.Controller.Contract.ReviewControllerContract;
import com.n11graduationproject.UserReviewService.DTO.ReviewDTO;
import com.n11graduationproject.UserReviewService.Entity.Review;
import com.n11graduationproject.UserReviewService.Enum.Score;
import com.n11graduationproject.UserReviewService.Mapper.ReviewMapper;
import com.n11graduationproject.UserReviewService.Request.ReviewSaveRequest;
import com.n11graduationproject.UserReviewService.Service.CustomerService;
import com.n11graduationproject.UserReviewService.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewControllerContractImpl implements ReviewControllerContract {
    private final ReviewService reviewService;
    private final CustomerService customerService;
    @Override
    public ReviewDTO save(ReviewSaveRequest reviewSaveRequest) {
        Review review = ReviewMapper.INSTANCE.convertToEntity(reviewSaveRequest,customerService);
        review = reviewService.save(review);
        return ReviewMapper.INSTANCE.convertToDTO(review);
    }

    @Override
    public void delete(Long id) {
        reviewService.delete(id);
    }

    @Override
    public ReviewDTO updateReview(Long id,String comment) {
        Review review = reviewService.findById(id);
        review.setComment(comment);
        review =reviewService.save(review);
        return ReviewMapper.INSTANCE.convertToDTO(review);
    }

    @Override
    public ReviewDTO updateScore(Long id,int score) {
        Review review = reviewService.findById(id);
        review.setScore(Score.fromValue(score));
        review =reviewService.save(review);
        return ReviewMapper.INSTANCE.convertToDTO(review);
    }

    @Override
    public List<ReviewDTO> findByRestaurantId(Long id) {
        List<Review> byRestaurantId = reviewService.findByRestaurantId(id);
       return ReviewMapper.INSTANCE.convertToDTO(byRestaurantId);
    }
}
