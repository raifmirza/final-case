package com.n11graduationproject.UserReviewService.Mapper;

import com.n11graduationproject.UserReviewService.DTO.ReviewDTO;
import com.n11graduationproject.UserReviewService.Entity.Review;
import com.n11graduationproject.UserReviewService.Enum.Score;
import com.n11graduationproject.UserReviewService.Repository.CustomerRepository;
import com.n11graduationproject.UserReviewService.Repository.ReviewRepository;
import com.n11graduationproject.UserReviewService.Request.ReviewSaveRequest;
import com.n11graduationproject.UserReviewService.Service.CustomerService;
import com.n11graduationproject.UserReviewService.Service.ReviewService;
import jakarta.persistence.MappedSuperclass;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target="customerName",source = "customerID.name")
    @Mapping(target = "customerSurname",source = "customerID.surname")
    @Mapping(target = "score",source = "score")
    ReviewDTO convertToDTO(Review review);

    default int map(Score score){
        return score.getScore();
    }

    @AfterMapping
    default void updateReviewDTOAfter(Review review, ReviewDTO reviewDTO){

    }


    @Mapping(target = "score",ignore = true)
    @Mapping(target = "customerID",ignore = true)
    Review convertToEntity(ReviewSaveRequest reviewSaveRequest);

    @AfterMapping
    default void updateReviewAfter(ReviewSaveRequest reviewSaveRequest, @MappingTarget Review review, @Context CustomerService customerService){
        review.setScore(Score.fromValue(reviewSaveRequest.score()));
        review.setCustomerID(customerService.findById(reviewSaveRequest.customerID()));
    }
}
