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
class CustomerControllerTest extends BaseControllerTest{


    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        mapper=new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void shouldGetAll() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldSave() throws Exception {
        String requestAsString = "{\n" +
                "  \"name\": \"controller test\",\n" +
                "  \"surname\": \"string\",\n" +
                "  \"email\": \"string@gmail.com\",\n" +
                "  \"latitude\": 90,\n" +
                "  \"longitude\": 180\n" +
                "}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers").content(requestAsString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);

    }
    @Test
    void shouldUpdateName() throws Exception {
        String name = "new name";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/customers/update-name-1001").content(name)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldUpdateSurname() throws Exception {
        String surname = "stringSurname";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/customers/update-surname-1001").content(surname)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldUpdateEmail() throws Exception {
        String email = "str@gmail.com";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/customers/update-email-1001").content(email)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldUpdateCoordinate() throws Exception {
        String coordinate = "{\n" +
                "  \"latitude\": 32.43345,\n" +
                "  \"longitude\": 123.43243\n" +
                "}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/customers/update-coordinate-1001").content(coordinate)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }
    @Test
    void shouldDelete()throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/customers/1002"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertTrue(success);
    }

    @Test
    void shouldNotDeleteNotFoundId()throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/customers/10000"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();

        boolean success = isSuccess(mvcResult);
        assertFalse(success);
    }
    @Test
    void shouldNotDeleteInvalidId() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/customers/abc"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(status,400);
    }
}