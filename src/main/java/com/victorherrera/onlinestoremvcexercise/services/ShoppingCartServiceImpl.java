package com.victorherrera.onlinestoremvcexercise.services;

import com.victorherrera.onlinestoremvcexercise.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Set<CartItem> cartItems = new HashSet<>();

    private LaptopService laptopService;

    public ShoppingCartServiceImpl(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @Override
    public void addToCart(CartItem object) {
        object.setSubtotal();
        object.setLaptop(laptopService.findById(object.getItemId()));
        cartItems.add(object);
    }

    @Override
    public void removeFromCart(CartItem object) {
        cartItems.remove(object);
    }

    @Override
    public Set<CartItem> getCartItems() {
        return this.cartItems;
    }
}
