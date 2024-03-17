package org.n11graduationproject.restaurantservice.Controller;

import lombok.RequiredArgsConstructor;
import org.n11graduationproject.restaurantservice.Client.CustomerClient;
import org.n11graduationproject.restaurantservice.Controller.Contract.RestaurantControllerContact;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTO;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTOWithReviews;
import org.n11graduationproject.restaurantservice.DTO.ReviewDTO;
import org.n11graduationproject.restaurantservice.Entity.Coordinate;
import org.n11graduationproject.restaurantservice.Entity.Restaurant;
import org.n11graduationproject.restaurantservice.General.RestResponse;
import org.n11graduationproject.restaurantservice.Mapper.RestaurantMapper;
import org.n11graduationproject.restaurantservice.Repository.RestaurantRepository;
import org.n11graduationproject.restaurantservice.Request.RestaurantSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantControllerContact contract;



    @GetMapping
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> findAll(){
        List<RestaurantDTO> restaurants = contract.findAll();
        RestResponse<List<RestaurantDTO>> listRestResponse = RestResponse.of(restaurants);
        listRestResponse.setMessages("Restaurants found successfully.");
        return ResponseEntity.ok(listRestResponse);
    }

    @PostMapping
    public ResponseEntity<RestResponse<RestaurantDTO>> save(@RequestBody @Valid RestaurantSaveRequest restaurantSaveRequest){
        RestaurantDTO restaurant = contract.save(restaurantSaveRequest);
        RestResponse<RestaurantDTO> restaurantDTORestResponse = RestResponse.of(restaurant);
        restaurantDTORestResponse.setMessages("Restaurant saved successfully.");
        return ResponseEntity.ok(restaurantDTORestResponse);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(){
        contract.deleteAll();
        return ResponseEntity.ok("All restaurants deleted.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        contract.deleteById(id);
        return ResponseEntity.ok("Restaurant with id " +id +" deleted.");
    }

    @GetMapping("/reviews")
    public ResponseEntity<RestResponse<RestaurantDTOWithReviews>> findWithReviews(@RequestParam Long id){
        RestaurantDTOWithReviews byIdWithReviews = contract.findByIdWithReviews(id);
        RestResponse<RestaurantDTOWithReviews> restaurantDTOWithReviewsRestResponse = RestResponse.of(byIdWithReviews);
        restaurantDTOWithReviewsRestResponse.setMessages("Restaurant with id "+id+" and its review returned.");
        return ResponseEntity.ok(restaurantDTOWithReviewsRestResponse);
    }

    @PatchMapping("/{id}-update-name")
    public ResponseEntity<RestResponse<RestaurantDTO>> updateName(@PathVariable Long id,@RequestBody String name){
        RestaurantDTO restaurantDTO = contract.updateName(id, name);
        RestResponse<RestaurantDTO> restaurantDTORestResponse = RestResponse.of(restaurantDTO);
        restaurantDTORestResponse.setMessages("Restaurant name updated successfully.");
        return ResponseEntity.ok(restaurantDTORestResponse);
    }

    @PatchMapping("/{id}-update-coordinate")
    public ResponseEntity<RestResponse<RestaurantDTO>> updateCoordinate(@PathVariable Long id,@RequestBody Coordinate coordinate){
        RestaurantDTO restaurantDTO = contract.updateCoordinate(id, coordinate);
        RestResponse<RestaurantDTO> restaurantDTORestResponse = RestResponse.of(restaurantDTO);
        restaurantDTORestResponse.setMessages("Restaurant coordinate updated successfully.");
        return ResponseEntity.ok(restaurantDTORestResponse);
    }

    @PatchMapping("/{id}-update-type")
    public ResponseEntity<RestResponse<RestaurantDTO>> updateType(@PathVariable Long id,@RequestBody String type){
        RestaurantDTO restaurantDTO = contract.updateType(id, type);
        RestResponse<RestaurantDTO> restaurantDTORestResponse = RestResponse.of(restaurantDTO);
        restaurantDTORestResponse.setMessages("Restaurant type updated successfully.");
        return ResponseEntity.ok(restaurantDTORestResponse);
    }

    @PatchMapping("/{id}-update-score")
    public ResponseEntity<RestResponse<RestaurantDTO>> updateScore(@PathVariable Long id,@RequestBody double score){
        RestaurantDTO restaurantDTO = contract.updateScore(id, score);
        RestResponse<RestaurantDTO> restaurantDTORestResponse = RestResponse.of(restaurantDTO);
        restaurantDTORestResponse.setMessages("Restaurant score updated successfully.");
        return ResponseEntity.ok(restaurantDTORestResponse);
    }

    @GetMapping("/getCloseRestaurants")
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> getClose(@RequestParam double Latitude,@RequestParam double Longitude,@RequestParam double Radius){
        List<RestaurantDTO> close = contract.getClose(Latitude, Longitude, Radius);
        RestResponse<List<RestaurantDTO>> listRestResponse = RestResponse.of(close);
        listRestResponse.setMessages("Close restaurants listed.");
        return ResponseEntity.ok(listRestResponse);
    }
}
