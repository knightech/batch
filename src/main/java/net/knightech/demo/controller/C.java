package net.knightech.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class C {
    
    @RequestMapping("/")
    public String asdf(){
        return "asdf";
    }
}
