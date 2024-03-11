package com.n11graduationproject.UserReviewService.Controller;

import com.n11graduationproject.UserReviewService.Controller.Contract.CustomerControllerContract;
import com.n11graduationproject.UserReviewService.DTO.CustomerDTO;
import com.n11graduationproject.UserReviewService.Request.CustomerSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerControllerContract contract;

    @PostMapping
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerSaveRequest customerSaveRequest){
        CustomerDTO customerDto = contract.save(customerSaveRequest);
        return ResponseEntity.ok(customerDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        contract.delete(id);
        return ResponseEntity.ok("Customer has deleted successfully.");
    }
}
