package com.n11graduationproject.UserReviewService.Controller.Contract.Impl;

import com.n11graduationproject.UserReviewService.Controller.Contract.CustomerControllerContract;
import com.n11graduationproject.UserReviewService.DTO.CustomerDTO;
import com.n11graduationproject.UserReviewService.Entity.Coordinate;
import com.n11graduationproject.UserReviewService.Entity.Customer;
import com.n11graduationproject.UserReviewService.Mapper.CustomerMapper;
import com.n11graduationproject.UserReviewService.Request.CoordinateUpdateRequest;
import com.n11graduationproject.UserReviewService.Request.CustomerSaveRequest;
import com.n11graduationproject.UserReviewService.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {
    private final CustomerService service;

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customers = service.findAll();
        return CustomerMapper.INSTANCE.convertToDTO(customers);
    }

    @Override
    public CustomerDTO save(CustomerSaveRequest customerSaveRequest) {
        Customer customer = CustomerMapper.INSTANCE.convertToEntity(customerSaveRequest);
        customer = service.save(customer);
        return CustomerMapper.INSTANCE.convertToDTO(customer);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public CustomerDTO updateEmail(Long id, String email) {
        Customer customer = service.findById(id);
        customer.setEmail(email);
        customer = service.save(customer);
        return CustomerMapper.INSTANCE.convertToDTO(customer);
    }

    @Override
    public CustomerDTO updateName(Long id, String name) {
        Customer customer = service.findById(id);
        customer.setName(name);
        customer = service.save(customer);
        return CustomerMapper.INSTANCE.convertToDTO(customer);
    }

    @Override
    public CustomerDTO updateSurname(Long id, String surname) {
        Customer customer = service.findById(id);
        customer.setSurname(surname);
        customer = service.save(customer);
        return CustomerMapper.INSTANCE.convertToDTO(customer);
    }

    @Override
    public CustomerDTO updateCoordinate(Long id, CoordinateUpdateRequest coordinateUpdateRequest) {
        Customer customer = service.findById(id);
        Coordinate coordinate = new Coordinate(coordinateUpdateRequest.latitude(),coordinateUpdateRequest.longitude());
        customer.setCoordinate(coordinate);
        customer = service.save(customer);
        return CustomerMapper.INSTANCE.convertToDTO(customer);
    }
}
