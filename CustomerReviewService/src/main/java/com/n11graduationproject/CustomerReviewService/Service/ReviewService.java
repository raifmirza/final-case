package com.n11graduationproject.UserReviewService.Service;

import com.n11graduationproject.UserReviewService.Entity.Review;
import com.n11graduationproject.UserReviewService.Repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;

    public Review save(Review review){
        return repository.save(review);
    }

    public Review findById(Long id){
        Optional<Review> review = repository.findById(id);
        if(review.isPresent()){
            return review.get();
        }
        else{
            throw new EntityNotFoundException("Review not found");
        }
    }

    public void delete(Long id){
        Review review = findById(id);
        repository.delete(review);
    }

    public List<Review> findByRestaurantId(Long restaurantId){
        return repository.findByRestaurantId(restaurantId);
    }
}
