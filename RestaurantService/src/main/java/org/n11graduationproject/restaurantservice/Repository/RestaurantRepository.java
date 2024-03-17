package org.n11graduationproject.restaurantservice.Repository;

import org.n11graduationproject.restaurantservice.Entity.Restaurant;
import org.springframework.data.repository.query.Param;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface RestaurantRepository extends SolrCrudRepository<Restaurant,String> {

    public List<Restaurant> findByName(String name);
    @Query("fq={!geofilt sfield=location pt=?0,?1 d=?2}")
    public List<Restaurant> findByLatLonDistance(Double lat,  Double lon,  Double d);
    @Query("fq={!geofilt sfield=location pt=-?0,?1 d=?2}")
    public List<Restaurant> findByLatLonDistanceLatNeg(Double lat,  Double lon,  Double d);
    @Query("fq={!geofilt sfield=location pt=?0,-?1 d=?2}")
    public List<Restaurant> findByLatLonDistanceLonNeg(Double lat,  Double lon,  Double d);
    @Query("fq={!geofilt sfield=location pt=-?0,-?1 d=?2}")
    public List<Restaurant> findByLatLonDistanceLatLonNeg(Double lat,  Double lon,  Double d);
}

