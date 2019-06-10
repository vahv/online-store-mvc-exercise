package com.victorherrera.onlinestoremvcexercise.controllers;

import com.victorherrera.onlinestoremvcexercise.model.CartItem;
import com.victorherrera.onlinestoremvcexercise.services.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddToCartController {
    ShoppingCartService shoppingCartService;

    public AddToCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute(name = "cartItem") CartItem cartItem, Model model){
        shoppingCartService.addToCart(cartItem);
        model.addAttribute("cartItems", shoppingCartService.getCartItems());
        return "cart";
    }
}
