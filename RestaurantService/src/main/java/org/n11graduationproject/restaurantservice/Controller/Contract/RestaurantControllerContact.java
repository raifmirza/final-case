package org.n11graduationproject.restaurantservice.Controller.Contract;

import org.n11graduationproject.restaurantservice.DTO.RestaurantDTO;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTOWithReviews;
import org.n11graduationproject.restaurantservice.Entity.Coordinate;
import org.n11graduationproject.restaurantservice.Request.RestaurantSaveRequest;

import java.util.List;

public interface RestaurantControllerContact {
    public List<RestaurantDTO> findAll();
    public RestaurantDTO save(RestaurantSaveRequest saveRequest);
    public void deleteAll();
    public void deleteById(Long id);
    public RestaurantDTOWithReviews findByIdWithReviews(Long id);
    public RestaurantDTO updateName(Long id,String name);
    public RestaurantDTO updateCoordinate(Long id, Coordinate coordinate);
    public RestaurantDTO updateType(Long id ,String type);
    public RestaurantDTO updateScore(Long id,double score);
    public List<RestaurantDTO> getClose(double lat,double lon,double d);

}
