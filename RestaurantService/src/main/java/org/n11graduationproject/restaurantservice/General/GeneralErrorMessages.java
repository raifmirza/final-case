package org.n11graduationproject.restaurantservice.General;

import java.time.LocalDateTime;

public record GeneralErrorMessages(LocalDateTime localDateTime,String message,String description) {
}
