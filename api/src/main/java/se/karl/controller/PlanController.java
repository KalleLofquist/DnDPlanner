package se.karl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PlanController {

    @GetMapping(value = "/hello", produces = "application/json")
    public Map<String, String> hello() {
        return Map.of("message", "Hello World!");
    }

}
