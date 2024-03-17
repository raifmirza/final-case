package com.n11graduationproject.CustomerReviewService.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.n11graduationproject.CustomerReviewService.General.RestResponse;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;

public class BaseControllerTest {

    protected ObjectMapper mapper;

    protected boolean isSuccess(MvcResult mvcResult) throws Exception{
        MockHttpServletResponse response = mvcResult.getResponse();
        String content = response.getContentAsString();

        RestResponse restResponse = mapper.readValue(content,RestResponse.class);
        return restResponse.isSuccess();
    }
}
