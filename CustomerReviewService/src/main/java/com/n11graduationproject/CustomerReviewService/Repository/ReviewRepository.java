package com.n11graduationproject.UserReviewService.Repository;

import com.n11graduationproject.UserReviewService.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    public List<Review> findByRestaurantId(Long id);
}
