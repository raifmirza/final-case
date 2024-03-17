package com.n11graduationproject.CustomerReviewService.Controller.Contract;

import com.n11graduationproject.CustomerReviewService.DTO.CustomerDTO;
import com.n11graduationproject.CustomerReviewService.Request.CoordinateUpdateRequest;
import com.n11graduationproject.CustomerReviewService.Request.CustomerSaveRequest;

import java.util.List;

public interface CustomerControllerContract {

    public List<CustomerDTO> getAll();
    public CustomerDTO save(CustomerSaveRequest customerSaveRequest);
    public void delete(Long id);
    public CustomerDTO updateEmail(Long id,String email);
    public CustomerDTO updateName(Long id,String name);
    public CustomerDTO updateSurname(Long id,String surname);
    public CustomerDTO updateCoordinate(Long id, CoordinateUpdateRequest coordinate);

}
