package org.n11graduationproject.restaurantservice.Mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTO;
import org.n11graduationproject.restaurantservice.DTO.RestaurantDTOWithReviews;
import org.n11graduationproject.restaurantservice.DTO.ReviewDTO;
import org.n11graduationproject.restaurantservice.Entity.Restaurant;
import org.n11graduationproject.restaurantservice.Request.RestaurantSaveRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-16T16:03:34+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant convertToRestaurant(RestaurantSaveRequest saveRequest) {
        if ( saveRequest == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId( saveRequest.id() );
        restaurant.setName( saveRequest.name() );
        restaurant.setType( saveRequest.type() );
        restaurant.setScore( String.valueOf( saveRequest.score() ) );
        restaurant.setLatitude( String.valueOf( saveRequest.latitude() ) );
        restaurant.setLongitude( String.valueOf( saveRequest.longitude() ) );

        updateRestaurantAfter( saveRequest, restaurant );

        return restaurant;
    }

    @Override
    public RestaurantDTO convertoDTO(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String type = null;
        double score = 0.0d;
        double latitude = 0.0d;
        double longitude = 0.0d;

        id = restaurant.getId();
        name = restaurant.getName();
        type = restaurant.getType();
        if ( restaurant.getScore() != null ) {
            score = Double.parseDouble( restaurant.getScore() );
        }
        if ( restaurant.getLatitude() != null ) {
            latitude = Double.parseDouble( restaurant.getLatitude() );
        }
        if ( restaurant.getLongitude() != null ) {
            longitude = Double.parseDouble( restaurant.getLongitude() );
        }

        RestaurantDTO restaurantDTO = new RestaurantDTO( id, name, type, score, latitude, longitude );

        return restaurantDTO;
    }

    @Override
    public List<RestaurantDTO> convertToDTOList(List<Restaurant> restaurants) {
        if ( restaurants == null ) {
            return null;
        }

        List<RestaurantDTO> list = new ArrayList<RestaurantDTO>( restaurants.size() );
        for ( Restaurant restaurant : restaurants ) {
            list.add( convertoDTO( restaurant ) );
        }

        return list;
    }

    @Override
    public RestaurantDTOWithReviews convertToDTOWithReviews(Restaurant restaurant, List<ReviewDTO> reviewDTOList) {
        if ( restaurant == null && reviewDTOList == null ) {
            return null;
        }

        double latitude = 0.0d;
        double longitude = 0.0d;
        String name = null;
        String type = null;
        double score = 0.0d;
        if ( restaurant != null ) {
            if ( restaurant.getLatitude() != null ) {
                latitude = Double.parseDouble( restaurant.getLatitude() );
            }
            if ( restaurant.getLongitude() != null ) {
                longitude = Double.parseDouble( restaurant.getLongitude() );
            }
            name = restaurant.getName();
            type = restaurant.getType();
            if ( restaurant.getScore() != null ) {
                score = Double.parseDouble( restaurant.getScore() );
            }
        }
        List<ReviewDTO> reviewDTOList1 = null;
        if ( reviewDTOList != null ) {
            List<ReviewDTO> list = reviewDTOList;
            if ( list != null ) {
                reviewDTOList1 = new ArrayList<ReviewDTO>( list );
            }
        }

        RestaurantDTOWithReviews restaurantDTOWithReviews = new RestaurantDTOWithReviews( name, type, score, latitude, longitude, reviewDTOList1 );

        return restaurantDTOWithReviews;
    }
}
