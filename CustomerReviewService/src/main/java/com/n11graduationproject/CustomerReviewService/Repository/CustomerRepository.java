package com.n11graduationproject.CustomerReviewService.Repository;

import com.n11graduationproject.CustomerReviewService.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
