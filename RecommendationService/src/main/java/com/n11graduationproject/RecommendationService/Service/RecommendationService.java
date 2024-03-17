package com.n11graduationproject.RecommendationService.Service;

import com.n11graduationproject.RecommendationService.Client.RestaurantClient;
import com.n11graduationproject.RecommendationService.DTO.RestaurantDTO;
import com.n11graduationproject.RecommendationService.General.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RestaurantClient client;

    public List<RestaurantDTO> recommendRestaurants(double lat,double lon,double d){
        HashMap<String, Double> scores = new HashMap<>();
        ResponseEntity<RestResponse<List<RestaurantDTO>>> close = client.getClose(lat, lon, d);
        List<RestaurantDTO> data = close.getBody().getData();
        for(RestaurantDTO restaurantDTO:data){
            scores.put(restaurantDTO.id(),calculateScore(restaurantDTO.score(),lat,lon,restaurantDTO.latitude(),restaurantDTO.longitude()));
        }
        Map<String, Double> sortedScores = sortScores(scores);
        ArrayList<String> names = new ArrayList<>();
        int count = 0;
        for(Map.Entry<String ,Double> entry:sortedScores.entrySet()){
            if(count >= 3){
                break;
            }
            names.add(entry.getKey());
            count++;
        }
        return data.stream().filter(p-> names.contains(p.id())).collect(Collectors.toList());

    }
    public static Map<String,Double> sortScores(Map<String,Double> scores){
        LinkedHashMap<String,Double> sortedScores = new LinkedHashMap<>();
        ArrayList<Double> list = new ArrayList<>();
        for(Map.Entry<String,Double> entry:scores.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list,Comparator.reverseOrder());   
        for(double score : list){
            for(Map.Entry<String,Double> entry:scores.entrySet()){
                if(entry.getValue().equals(score)){
                    sortedScores.put(entry.getKey(), score);
                }
            }
        }
        return sortedScores;
    }

    public Double calculateScore(double score,double lat,double lon,double lat1,double lon1){
        Double distanceScore = calculateDistance(lat,lon,lat1,lon1) * 30;
        Double rateScore = score * 70;
        return rateScore+distanceScore;
    }
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int earthRadius = 6371; // Earth radius in kilometers

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

}
