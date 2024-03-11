package com.n11graduationproject.UserReviewService.Repository;

import com.n11graduationproject.UserReviewService.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
