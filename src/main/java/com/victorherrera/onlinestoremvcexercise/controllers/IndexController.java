package com.victorherrera.onlinestoremvcexercise.controllers;

import com.victorherrera.onlinestoremvcexercise.services.LaptopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final LaptopService laptopService;

    public IndexController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("laptops", laptopService.findAll());
        return "index";
    }
}
