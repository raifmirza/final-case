package com.n11graduationproject.CustomerReviewService.General;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class RestResponse<T> {
    private T data;
    private LocalDateTime responseDate;
    private boolean isSuccess;
    private String messages;
    public RestResponse(T data, boolean isSuccess){
        this.data = data;
        this.isSuccess = isSuccess;
        this.responseDate = LocalDateTime.now();
        this.messages = "Successfully operation";
    }

    public static <T> RestResponse<T> of(T t){
        return new RestResponse<>(t, true);
    }


    public static <T> RestResponse<T> error(T t){
        RestResponse<T> tRestResponse = new RestResponse<>(t, false);
        tRestResponse.setMessages("Error has occurred.");
        return tRestResponse;
    }
}
