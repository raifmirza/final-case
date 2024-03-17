package com.n11graduationproject.CustomerReviewService.Mapper;


import com.n11graduationproject.CustomerReviewService.DTO.CustomerDTO;
import com.n11graduationproject.CustomerReviewService.Entity.Coordinate;
import com.n11graduationproject.CustomerReviewService.Entity.Customer;
import com.n11graduationproject.CustomerReviewService.Request.CustomerSaveRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO convertToDTO(Customer customer);

    List<CustomerDTO> convertToDTO(List<Customer> customerList);

    @Mapping(target = "status",constant = "ACTIVE")
    @Mapping(target = "coordinate",ignore = true)
    Customer convertToEntity(CustomerSaveRequest customerSaveRequest);

    @AfterMapping
    default void updateCustomer(CustomerSaveRequest customerSaveRequest, @MappingTarget Customer customer){
        Coordinate coordinate = new Coordinate(customerSaveRequest.latitude(),customerSaveRequest.longitude());
        customer.setCoordinate(coordinate);
    }

}
