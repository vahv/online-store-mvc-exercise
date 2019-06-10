package com.victorherrera.onlinestoremvcexercise.services;

import com.victorherrera.onlinestoremvcexercise.model.CartItem;

import java.util.Set;

public interface ShoppingCartService {

     void addToCart(CartItem object);
     void removeFromCart(CartItem object);
     Set<CartItem> getCartItems();
     Double getTotal();

}
