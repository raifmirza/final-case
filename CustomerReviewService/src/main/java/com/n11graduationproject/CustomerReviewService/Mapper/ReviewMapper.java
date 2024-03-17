package com.n11graduationproject.CustomerReviewService.Mapper;

import com.n11graduationproject.CustomerReviewService.DTO.ReviewDTO;
import com.n11graduationproject.CustomerReviewService.Entity.Review;
import com.n11graduationproject.CustomerReviewService.Enum.Score;
import com.n11graduationproject.CustomerReviewService.Request.ReviewSaveRequest;
import com.n11graduationproject.CustomerReviewService.Service.CustomerService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target="customerName",source = "customerID.name")
    @Mapping(target = "customerSurname",source = "customerID.surname")
    @Mapping(target = "score",source = "score")
    ReviewDTO convertToDTO(Review review);
    @Mapping(target="customerName",source = "customerID.name")
    @Mapping(target = "customerSurname",source = "customerID.surname")
    @Mapping(target = "score",source = "score")
    List<ReviewDTO> convertToDTO(List<Review> reviews);

    default int map(Score score){
        return score.getScore();
    }



    @Mapping(target = "score",ignore = true)
    @Mapping(target = "customerID",ignore = true)
    Review convertToEntity(ReviewSaveRequest reviewSaveRequest,@Context CustomerService customerService);

    @AfterMapping
    default void updateReviewAfter(ReviewSaveRequest reviewSaveRequest, @MappingTarget Review review, @Context CustomerService customerService){
        review.setScore(Score.fromValue(reviewSaveRequest.score()));
        review.setCustomerID(customerService.findById(reviewSaveRequest.customerID()));
    }
}
