package com.inserta.myfqcontroller.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/validar")
    public String inicioSesion(){

        return "home";
    }
}
