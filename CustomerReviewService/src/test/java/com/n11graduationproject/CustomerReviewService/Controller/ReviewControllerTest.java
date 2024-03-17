package com.n11graduationproject.CustomerReviewService.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.n11graduationproject.CustomerReviewService.CustomerReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {CustomerReviewService.class})
class ReviewControllerTest extends BaseControllerTest{
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        mapper=new ObjectMapper().registerModule(new JavaTimeModule());
    }
    @Test
    void shouldSave() throws Exception {
        String requestAsString = "{\n" +
                "  \"customerID\": 1000,\n" +
                "  \"restaurantId\": 2,\n" +
                "  \"comment\": \"stringasdgasdgasdgasdg\",\n" +
                "  \"score\": 5\n" +
                "}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/reviews").content(requestAsString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldDelete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/reviews/2001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldUpdateReview() throws Exception {
        String review = "new review good baaad.";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/reviews/update-review-2000").content(review)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldUpdateScore() throws Exception {
        String score = "3";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/reviews/update-score-2000").content(score)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldFindByRestaurantId() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/reviews").param("restaurantId","2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }
}