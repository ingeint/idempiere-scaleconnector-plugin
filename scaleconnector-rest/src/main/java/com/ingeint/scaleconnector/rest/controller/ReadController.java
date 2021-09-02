package com.ingeint.scaleconnector.rest.controller;

import com.ingeint.scaleconnector.core.Request;
import com.ingeint.scaleconnector.core.Response;
import com.ingeint.scaleconnector.service.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadController {

    private ResponseBuilder responseBuilder;

    @Autowired
    public ReadController(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    @PostMapping("/read")
    public Response read(@RequestBody Request request) {
        return responseBuilder.build(request);
    }

}
