package org.n11graduationproject.restaurantservice.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.n11graduationproject.restaurantservice.Entity.Restaurant;
import org.n11graduationproject.restaurantservice.Exception.EntityNotFoundException;
import org.n11graduationproject.restaurantservice.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {
    private final RestaurantRepository repository;

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public List<Restaurant> findAll() {
        Iterable<Restaurant> restaurantsIter = repository.findAll();
        List<Restaurant> restaurants = new ArrayList<>();
        restaurantsIter.forEach(restaurants::add);
        return restaurants;
    }

    public Restaurant findById(Long id){
        Optional<Restaurant> restaurant = repository.findById(String.valueOf(id));
        if(restaurant.isPresent()){
            return restaurant.get();
        }
        else{
            throw new EntityNotFoundException("Entity is not exists");
        }
    }
    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(Long id) {
        Restaurant restaurant = findById(id);
        try{
            repository.deleteById(String.valueOf(id));
        }
        catch (RuntimeException e){
            log.info(e.getMessage());
        }
    }
    public List<Restaurant> findByLatLonD(double lat,double lon,double d){
        if(lat < 0 && lon >= 0){
            return repository.findByLatLonDistanceLatNeg(-lat,lon,d);
        }
        if(lon<0 && lat >= 0){
            return repository.findByLatLonDistanceLonNeg(lat,-lon,d);
        }
        if(lat<0 && lon<0){
            return repository.findByLatLonDistanceLatLonNeg(-lat,-lon,d);
        }
        if(lat>=0 && lon>=0){
            return repository.findByLatLonDistance(lat,lon,d);
        }
        return null;
    }
}
