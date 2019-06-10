package com.victorherrera.onlinestoremvcexercise.controllers;

import com.victorherrera.onlinestoremvcexercise.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalesController {
    private SaleService saleService;

    @Autowired
    public SalesController(SaleService saleService) {
        this.saleService = saleService;
    }

    @RequestMapping(value = "/compras", method = RequestMethod.GET)
    public String loadPurchasesPage(Model model){
        model.addAttribute("sales", saleService.findAll());
        return "purchases";
    }
}
