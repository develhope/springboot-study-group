package com.example.demoweb;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/v1")
@Tag(name = "Hello World Controller!")
public class HelloWorldController {

    @RequestMapping(method=GET, path="/helloWorld")
    public UserName greet(@RequestParam(value = "name", required = false, defaultValue = "Sasa") String name) {
        return new UserName("Hello World, " + name + "!");
    }
}
