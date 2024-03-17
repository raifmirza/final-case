package com.n11graduationproject.UserReviewService.Repository;

import com.n11graduationproject.UserReviewService.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
