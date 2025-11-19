package se.karl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class PlanController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public String hello() {
        return "Hello World!";
    }

}
