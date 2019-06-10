package com.victorherrera.onlinestoremvcexercise.services;

import com.victorherrera.onlinestoremvcexercise.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
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
        Iterator<CartItem> itr = this.cartItems.iterator();
        while (itr.hasNext()){
            CartItem item = itr.next();
            if (item.getItemId().equals(object.getItemId())) {
                item.setQuantity(item.getQuantity() + object.getQuantity());
                item.setSubtotal();
                return;
            }
        }
        object.setSubtotal();
        object.setLaptop(laptopService.findById(object.getItemId()));
        cartItems.add(object);
    }

    @Override
    public void removeFromCart(CartItem object) {
        Iterator<CartItem> itr = this.cartItems.iterator();
        while (itr.hasNext()){
            CartItem item = itr.next();
            if (item.getItemId().equals(object.getItemId())){
                this.cartItems.remove(item);
                return;
            }
        }
    }

    @Override
    public Set<CartItem> getCartItems() {
        return this.cartItems;

    }

    @Override
    public Double getTotal() {
        Double total = 0.0;
        Iterator<CartItem> itr = this.cartItems.iterator();
        while (itr.hasNext()) {
            total += itr.next().getSubtotal();
        }
        return total;
    }
}
