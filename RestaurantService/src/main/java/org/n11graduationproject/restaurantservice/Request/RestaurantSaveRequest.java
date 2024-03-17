package org.n11graduationproject.restaurantservice.Request;

import javax.validation.constraints.*;

public record RestaurantSaveRequest(String id, String name, String type,@NotNull@DecimalMax(value = "5.0") @DecimalMin(value = "1.0") double score,
                                    @NotNull
                                    @DecimalMax(value = "90.000000",message = "Latitude can be max 90.000000")
                                    @DecimalMin(value = "-90.000000",message = "Latitude must be at least -90.000000") double latitude,
                                    @NotNull
                                    @DecimalMax(value = "180.000000",message = "Longitude can be max 180.000000")
                                    @DecimalMin(value = "-180.000000",message = "Longitude must be at least -90.000000")double longitude)  {
}
