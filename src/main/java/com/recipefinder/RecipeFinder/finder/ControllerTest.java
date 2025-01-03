package com.recipefinder.RecipeFinder.finder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping("test")
    String test() {
        System.out.println("test");
        return "test";
    }
}
