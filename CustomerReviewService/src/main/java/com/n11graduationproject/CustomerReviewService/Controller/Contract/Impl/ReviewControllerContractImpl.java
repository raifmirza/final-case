package com.n11graduationproject.CustomerReviewService.Controller.Contract.Impl;

import com.n11graduationproject.CustomerReviewService.Controller.Contract.ReviewControllerContract;
import com.n11graduationproject.CustomerReviewService.DTO.ReviewDTO;
import com.n11graduationproject.CustomerReviewService.Entity.Review;
import com.n11graduationproject.CustomerReviewService.Enum.Score;
import com.n11graduationproject.CustomerReviewService.Mapper.ReviewMapper;
import com.n11graduationproject.CustomerReviewService.Request.ReviewSaveRequest;
import com.n11graduationproject.CustomerReviewService.Service.CustomerService;
import com.n11graduationproject.CustomerReviewService.Service.ReviewService;
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
