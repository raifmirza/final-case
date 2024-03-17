package org.n11graduationproject.restaurantservice.Controller.Contract.Impl;

import lombok.RequiredArgsConstructor;
import org.n11graduationproject.restaurantservice.Client.CustomerClient;
import org.n11graduationproject.restaurantservice.Controller.Contract.RestaurantControllerContact;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTO;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTOWithReviews;
import org.n11graduationproject.restaurantservice.DTO.ReviewDTO;
import org.n11graduationproject.restaurantservice.Entity.Coordinate;
import org.n11graduationproject.restaurantservice.Entity.Restaurant;
import org.n11graduationproject.restaurantservice.Mapper.RestaurantMapper;
import org.n11graduationproject.restaurantservice.Request.RestaurantSaveRequest;
import org.n11graduationproject.restaurantservice.Service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantControllerContactImpl implements RestaurantControllerContact {
    private final RestaurantService service;
    private final CustomerClient client;
    @Override
    public List<RestaurantDTO> findAll() {
        List<Restaurant> allRestaurants = service.findAll();
        return RestaurantMapper.INSTANCE.convertToDTOList(allRestaurants);
    }
    @Override
    public RestaurantDTO save(RestaurantSaveRequest saveRequest) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.convertToRestaurant(saveRequest);
        restaurant =service.save(restaurant);
        return RestaurantMapper.INSTANCE.convertoDTO(restaurant);
    }

    @Override
    public void deleteAll() {
        service.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public RestaurantDTOWithReviews findByIdWithReviews(Long id) {
        List<ReviewDTO> reviewDTOList = client.getReviewByRestaurantId(id).getBody().getData();
        Restaurant restaurant = service.findById(id);
        return RestaurantMapper.INSTANCE.convertToDTOWithReviews(restaurant,reviewDTOList);
    }

    @Override
    public RestaurantDTO updateName(Long id, String name) {
        Restaurant restaurant = service.findById(id);
        restaurant.setName(name);
        restaurant =service.save(restaurant);
        return RestaurantMapper.INSTANCE.convertoDTO(restaurant);
    }

    @Override
    public RestaurantDTO updateCoordinate(Long id, Coordinate coordinate) {
        Restaurant restaurant = service.findById(id);
        restaurant.setLatitude(String.valueOf(coordinate.getLatitude()));
        restaurant.setLongitude(String.valueOf(coordinate.getLongitude()));
        restaurant =service.save(restaurant);
        return RestaurantMapper.INSTANCE.convertoDTO(restaurant);
    }

    @Override
    public RestaurantDTO updateType(Long id, String type) {
        Restaurant restaurant = service.findById(id);
        restaurant.setType(type);
        restaurant =service.save(restaurant);
        return RestaurantMapper.INSTANCE.convertoDTO(restaurant);
    }

    @Override
    public RestaurantDTO updateScore(Long id, double score) {
        Restaurant restaurant = service.findById(id);
        restaurant.setScore(String.valueOf(score));
        restaurant =service.save(restaurant);
        return RestaurantMapper.INSTANCE.convertoDTO(restaurant);
    }

    @Override
    public List<RestaurantDTO> getClose(double lat, double lon, double d) {
        List<Restaurant> byLatLonD = service.findByLatLonD(lat, lon, d);
        return RestaurantMapper.INSTANCE.convertToDTOList(byLatLonD);
    }

}
