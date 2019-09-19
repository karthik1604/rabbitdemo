package com.rabbit.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloPublisher helloPublisher;

    public HelloController(HelloPublisher helloPublisher) {
        this.helloPublisher = helloPublisher;
    }
    @GetMapping(value = "/send" )
    public void publish(){
        helloPublisher.send("message");
    }
}
