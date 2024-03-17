package com.n11graduationproject.UserReviewService.Controller;

import com.n11graduationproject.UserReviewService.Controller.Contract.Impl.CustomerControllerContractImpl;
import com.n11graduationproject.UserReviewService.DTO.CustomerDTO;
import com.n11graduationproject.UserReviewService.Entity.Coordinate;
import com.n11graduationproject.UserReviewService.Entity.Customer;
import com.n11graduationproject.UserReviewService.Enum.Status;
import com.n11graduationproject.UserReviewService.Mapper.CustomerMapper;
import com.n11graduationproject.UserReviewService.Request.CoordinateUpdateRequest;
import com.n11graduationproject.UserReviewService.Request.CustomerSaveRequest;
import com.n11graduationproject.UserReviewService.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerContractTest {
    @Mock
    private CustomerService customerService;
    @Mock
    private CustomerMapper mapper;
    @InjectMocks
    private CustomerControllerContractImpl contract;

    @Test
    void save() {
        Coordinate coordinate = new Coordinate(12.32342,43.34345);
        CustomerSaveRequest customerSaveRequest = new CustomerSaveRequest("John","Doe","doe@gmail.com",12.32342,43.34345);
        Customer expectedCustomer = new Customer(1L,"John","Doe",
               "doe@gmail.com",coordinate ,Status.ACTIVE);
        CustomerDTO expectedDTO = new CustomerDTO("John","Doe","doe@gmail.com",coordinate,Status.ACTIVE);
        Mockito.lenient().when(mapper.convertToEntity(customerSaveRequest)).thenReturn(expectedCustomer);
        Mockito.when(customerService.save(Mockito.any())).thenReturn(expectedCustomer);
        Mockito.lenient().when(mapper.convertToDTO(expectedCustomer)).thenReturn(expectedDTO);

        CustomerDTO actualDTO = contract.save(customerSaveRequest);
        assertNotNull(actualDTO);
        assertEquals(actualDTO,expectedDTO);

    }

    @Test
    void delete() {
        contract.delete(12L);
        Mockito.verify(customerService).delete(Mockito.any());
    }

    @Test
    void updateName() {
        Coordinate coordinate = new Coordinate(12.32342,43.34345);
        Customer expectedCustomer = new Customer(1L,"John","Doe",
                "doe@gmail.com",coordinate ,Status.ACTIVE);
        String updatedName = "Michael";

        Mockito.when(customerService.findById(Mockito.any())).thenReturn(expectedCustomer);
        expectedCustomer.setName(updatedName);
        Mockito.when(customerService.save(expectedCustomer)).thenReturn(expectedCustomer);

        CustomerDTO result = contract.updateName(1L,updatedName);
        assertEquals(result.name(),expectedCustomer.getName());
    }

    @Test
    void updateSurname() {
        Coordinate coordinate = new Coordinate(12.32342,43.34345);
        Customer expectedCustomer = new Customer(1L,"John","Doe",
                "doe@gmail.com",coordinate ,Status.ACTIVE);
        String updatedSurname = "Carleone";

        Mockito.when(customerService.findById(Mockito.any())).thenReturn(expectedCustomer);
        expectedCustomer.setSurname(updatedSurname);
        Mockito.when(customerService.save(expectedCustomer)).thenReturn(expectedCustomer);

        CustomerDTO result = contract.updateSurname(1L,updatedSurname);
        assertEquals(result.surname(),expectedCustomer.getSurname());
    }

    @Test
    void updateEmail() {
        Coordinate coordinate = new Coordinate(12.32342,43.34345);
        Customer expectedCustomer = new Customer(1L,"John","Doe",
                "doe@gmail.com",coordinate ,Status.ACTIVE);
        String updatedEmail = "johndoe@gmail.com";

        Mockito.when(customerService.findById(Mockito.any())).thenReturn(expectedCustomer);
        expectedCustomer.setEmail(updatedEmail);
        Mockito.when(customerService.save(expectedCustomer)).thenReturn(expectedCustomer);

        CustomerDTO result = contract.updateEmail(1L,updatedEmail);
        assertEquals(result.email(),expectedCustomer.getEmail());
    }
    @Test
    void updateCoordinate(){
        Coordinate coordinate = new Coordinate(12.32342,43.34345);
        Customer expectedCustomer = new Customer(1L,"John","Doe",
                "doe@gmail.com",coordinate ,Status.ACTIVE);
        Coordinate updatedCoordinate = new Coordinate(32.23423,-32.234235);
        CoordinateUpdateRequest updateRequest = new CoordinateUpdateRequest(32.23423,-32.234235);
        Mockito.when(customerService.findById(Mockito.any())).thenReturn(expectedCustomer);
        expectedCustomer.setCoordinate(updatedCoordinate);
        Mockito.when(customerService.save(expectedCustomer)).thenReturn(expectedCustomer);

        CustomerDTO result = contract.updateCoordinate(1L,updateRequest);
        assertEquals(result.email(),expectedCustomer.getEmail());
    }
}