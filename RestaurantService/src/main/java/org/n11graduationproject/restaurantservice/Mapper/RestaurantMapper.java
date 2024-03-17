package org.n11graduationproject.restaurantservice.Mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTO;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTOWithReviews;
import org.n11graduationproject.restaurantservice.DTO.ReviewDTO;
import org.n11graduationproject.restaurantservice.Entity.Restaurant;
import org.n11graduationproject.restaurantservice.Request.RestaurantSaveRequest;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    @Mapping(target = "location",ignore = true)
    Restaurant convertToRestaurant(RestaurantSaveRequest saveRequest);

    @AfterMapping
    default void updateRestaurantAfter(RestaurantSaveRequest saveRequest, @MappingTarget Restaurant restaurant){
        double latitude = saveRequest.latitude();
        double longitude = saveRequest.longitude();
        String location = latitude + "," + longitude;
        restaurant.setLocation(location);
    }
    RestaurantDTO convertoDTO(Restaurant restaurant);

    List<RestaurantDTO> convertToDTOList(List<Restaurant> restaurants);

    @Mapping(target = "latitude",source = "restaurant.latitude")
    @Mapping(target = "longitude",source = "restaurant.longitude")
    RestaurantDTOWithReviews convertToDTOWithReviews(Restaurant restaurant, List<ReviewDTO> reviewDTOList);


}
