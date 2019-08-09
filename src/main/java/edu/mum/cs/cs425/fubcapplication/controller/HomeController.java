package edu.mum.cs.cs425.fubcapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/fubc", "/fubc/home"})
    public String displayHomePage(){
        return "home/index";
    }
}
