package com.n11graduationproject.UserReviewService.Controller;

import com.n11graduationproject.UserReviewService.Controller.Contract.CustomerControllerContract;
import com.n11graduationproject.UserReviewService.DTO.CustomerDTO;
import com.n11graduationproject.UserReviewService.Entity.Coordinate;
import com.n11graduationproject.UserReviewService.General.RestResponse;
import com.n11graduationproject.UserReviewService.Request.CoordinateUpdateRequest;
import com.n11graduationproject.UserReviewService.Request.CustomerSaveRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerControllerContract contract;

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> getAll(){
        List<CustomerDTO> customerDTOS = contract.getAll();
        RestResponse<List<CustomerDTO>> listRestResponse = RestResponse.of(customerDTOS);
        listRestResponse.setMessages("All customers returned.");
        return ResponseEntity.ok(listRestResponse);
    }

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody @Valid CustomerSaveRequest customerSaveRequest){
        CustomerDTO customerDto = contract.save(customerSaveRequest);
        RestResponse<CustomerDTO> response = RestResponse.of(customerDto);
        response.setMessages("Customer created successfully.");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> delete(@PathVariable Long id){
        contract.delete(id);
        RestResponse<String> response = RestResponse.of(null);
        response.setMessages("Customer deleted successfully.");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update-name-{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> updateName(@PathVariable Long id,@RequestBody @NotBlank String name){
        CustomerDTO customerDTO = contract.updateName(id, name);
        RestResponse<CustomerDTO> response = RestResponse.of(customerDTO);
        response.setMessages("Customer name updated successfully.");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update-surname-{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> updateSurname(@PathVariable Long id,@RequestBody @NotBlank String surname){
        CustomerDTO customerDTO = contract.updateSurname(id, surname);
        RestResponse<CustomerDTO> response = RestResponse.of(customerDTO);
        response.setMessages("Customer surname updated successfully.");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update-email-{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> updateEmail(@PathVariable Long id,@RequestBody @Email@NotBlank String email){
        CustomerDTO customerDTO = contract.updateEmail(id, email);
        RestResponse<CustomerDTO> response = RestResponse.of(customerDTO);
        response.setMessages("Customer email updated successfully.");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update-coordinate-{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> updateCoordinate(@PathVariable Long id, @RequestBody CoordinateUpdateRequest updateRequest){
        CustomerDTO customerDTO = contract.updateCoordinate(id, updateRequest);
        RestResponse<CustomerDTO> response = RestResponse.of(customerDTO);
        response.setMessages("Customer coordinate updated successfully.");
        return ResponseEntity.ok(response);
    }
}
