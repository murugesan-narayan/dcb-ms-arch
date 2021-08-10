package com.muru.dcb.cloud.api.gateway.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class FallbackController {
    @RequestMapping(value = "/userServiceFallback", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String userServiceFallback(){
        return "User Service is taking longer than expected. Please try again later.";
    }
    @RequestMapping(value = "/departmentServiceFallback", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String departmentServiceFallback(){
        return "Department Service is taking longer than expected. Please try again later.";
    }
}
