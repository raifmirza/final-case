package com.n11graduationproject.UserReviewService.Controller.Contract;

import com.n11graduationproject.UserReviewService.DTO.CustomerDTO;
import com.n11graduationproject.UserReviewService.Entity.Coordinate;
import com.n11graduationproject.UserReviewService.Request.CustomerSaveRequest;

public interface CustomerControllerContract {

    public CustomerDTO save(CustomerSaveRequest customerSaveRequest);
    public void delete(Long id);
    public CustomerDTO updateEmail(Long id,String email);
    public CustomerDTO updateName(Long id,String name);
    public CustomerDTO updateSurname(Long id,String surname);
    public CustomerDTO updateCoordinate(Long id, Coordinate coordinate);

}
