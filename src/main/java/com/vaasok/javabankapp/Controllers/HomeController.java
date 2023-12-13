package com.vaasok.javabankapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String home() {
        return "home.html"; // Здесь "index" - это имя вашего шаблона FreeMarker (например, index.html).
    }

}
