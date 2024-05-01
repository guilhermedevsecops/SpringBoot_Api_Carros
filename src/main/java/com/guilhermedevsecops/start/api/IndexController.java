package com.guilhermedevsecops.start.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String Get(){
        return "Api dos Carros";
    }
    
}
