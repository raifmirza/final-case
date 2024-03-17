package com.n11graduationproject.UserReviewService.Controller;

import com.n11graduationproject.UserReviewService.Controller.Contract.Impl.ReviewControllerContractImpl;
import com.n11graduationproject.UserReviewService.DTO.ReviewDTO;
import com.n11graduationproject.UserReviewService.Entity.Customer;
import com.n11graduationproject.UserReviewService.Entity.Review;
import com.n11graduationproject.UserReviewService.Enum.Score;
import com.n11graduationproject.UserReviewService.Mapper.ReviewMapper;
import com.n11graduationproject.UserReviewService.Request.ReviewSaveRequest;
import com.n11graduationproject.UserReviewService.Service.CustomerService;
import com.n11graduationproject.UserReviewService.Service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ReviewControllerContractTest {


    @Mock
    private ReviewService reviewService;
    @Mock
    private CustomerService customerService;
    @Mock
    private ReviewMapper mapper;
    @InjectMocks
    private ReviewControllerContractImpl contract;
    @Test
    void shouldSave() {
        Customer customer = new Customer();
        customer.setName("Raif");
        customer.setSurname("Erten");
        ReviewSaveRequest saveRequest = new ReviewSaveRequest(1L,1L,"good", 5);
        Review expected = new Review(1L,1L,customer,"good",Score.FIVE);
        ReviewDTO reviewDTO = new ReviewDTO("Raif","Erten",1L,"good",5);

        Mockito.lenient().when(mapper.convertToEntity(saveRequest,customerService)).thenReturn(expected);
        Mockito.when(reviewService.save(Mockito.any())).thenReturn(expected);
        Mockito.lenient().when(mapper.convertToDTO(expected)).thenReturn(reviewDTO);

        ReviewDTO result = contract.save(saveRequest);

        assertEquals(result.customerName(),reviewDTO.customerName());
        assertEquals(result.customerSurname(),reviewDTO.customerSurname());
        assertEquals(result.comment(),reviewDTO.comment());
        assertEquals(result.score(),reviewDTO.score());
    }

    @Test
    void shouldDelete() {
        contract.delete(12L);
        Mockito.verify(reviewService).delete(Mockito.any());
    }

    @Test
    void shouldUpdateReview() {
        Review expected = new Review(35L,1L,null,"good",Score.FIVE);
        String updatedComment = "very good";
        ReviewDTO expectedDTO = new ReviewDTO(null,null,1L,updatedComment,5);

        Mockito.when(reviewService.findById(Mockito.any())).thenReturn(expected);
        expected.setComment(updatedComment);
        Mockito.when(reviewService.save(Mockito.any())).thenReturn(expected);
        Mockito.lenient().when(mapper.convertToDTO(expected)).thenReturn(expectedDTO);


        ReviewDTO result = contract.updateReview(35L,updatedComment);

        assertEquals(result.comment(),expectedDTO.comment());
        assertEquals(result.score(),expectedDTO.score());

    }

    @Test
    void shouldUpdateScore() {
        Review expected = new Review(35L,1L,null,"good",Score.FIVE);
        int updatedScore = 4;
        ReviewDTO expectedDTO = new ReviewDTO(null,null,1L,"good",updatedScore);

        Mockito.when(reviewService.findById(Mockito.any())).thenReturn(expected);
        expected.setScore(Score.fromValue(updatedScore));
        Mockito.when(reviewService.save(Mockito.any())).thenReturn(expected);
        Mockito.lenient().when(mapper.convertToDTO(expected)).thenReturn(expectedDTO);


        ReviewDTO result = contract.updateScore(35L,updatedScore);

        assertEquals(result.comment(),expectedDTO.comment());
        assertEquals(result.score(),expectedDTO.score());
    }

    @Test
    void shouldFindByRestaurantId() {
        List<Review> reviews = new ArrayList<>();
        Review review1 = new Review();
        review1.setRestaurantId(12L);
        review1.setScore(Score.FIVE);
        Review review2 = new Review();
        review2.setRestaurantId(12L);
        review2.setScore(Score.FIVE);
        Review review3 = new Review();
        review3.setRestaurantId(12L);
        review3.setScore(Score.FIVE);
        reviews.add(review1);
        reviews.add(review2);
        reviews.add(review3);

        List<ReviewDTO> reviewDTOS = new ArrayList<>();
        ReviewDTO reviewDTO1 = new ReviewDTO(null,null,12L,null,5);
        ReviewDTO reviewDTO2 = new ReviewDTO(null,null,12L,null,5);
        ReviewDTO reviewDTO3 = new ReviewDTO(null,null,12L,null,5);
        reviewDTOS.add(reviewDTO1);
        reviewDTOS.add(reviewDTO2);
        reviewDTOS.add(reviewDTO3);


        Mockito.when(reviewService.findByRestaurantId(Mockito.any())).thenReturn(reviews);
        Mockito.lenient().when(mapper.convertToDTO(reviews)).thenReturn(reviewDTOS);

        List<ReviewDTO> result = contract.findByRestaurantId(12L);

        assertEquals(result.size(),reviewDTOS.size());

        for(int i = 0;i<result.size();i++){
            ReviewDTO reviewDTO = reviewDTOS.get(i);
            ReviewDTO resultDTo = result.get(i);

            assertEquals(reviewDTO.restaurantId(),resultDTo.restaurantId());
        }

    }
}