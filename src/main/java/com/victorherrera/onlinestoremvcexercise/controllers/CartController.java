package com.victorherrera.onlinestoremvcexercise.controllers;

import com.victorherrera.onlinestoremvcexercise.model.CartItem;
import com.victorherrera.onlinestoremvcexercise.services.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
    ShoppingCartService shoppingCartService;

    public CartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCartPage(Model model){
        model.addAttribute("cartItems", shoppingCartService.getCartItems());
        return "cart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute(name = "cartItem") CartItem cartItem, Model model){
        shoppingCartService.addToCart(cartItem);
        model.addAttribute("cartItems", shoppingCartService.getCartItems());
        model.addAttribute("total", shoppingCartService.getTotal());
        return "cart";
    }
    @RequestMapping(value = "/removeFromCart", method = RequestMethod.POST)
    public String removeFromCart(@ModelAttribute(name = "cartItem") CartItem cartItem, Model model){
        shoppingCartService.removeFromCart(cartItem);
        System.out.println(shoppingCartService.getCartItems());
        model.addAttribute("cartItems", shoppingCartService.getCartItems());
        model.addAttribute("total", shoppingCartService.getTotal());
        return "cart";
    }
}
