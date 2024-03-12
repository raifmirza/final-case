package com.n11graduationproject.UserReviewService.General;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class GeneralControllerAdvice {
    @ExceptionHandler
    public final ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e,WebRequest request){
        String message = e.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages);


        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleNotValidException(MethodArgumentNotValidException e, WebRequest request) {

        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages);


        return new ResponseEntity<>(restResponse, HttpStatus.CONFLICT);
    }
}
