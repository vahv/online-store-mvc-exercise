package com.victorherrera.onlinestoremvcexercise.services;

import com.victorherrera.onlinestoremvcexercise.model.CartItem;
import com.victorherrera.onlinestoremvcexercise.model.Sale;
import com.victorherrera.onlinestoremvcexercise.model.SoldLaptop;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Set<CartItem> cartItems = new HashSet<>();

    private LaptopService laptopService;
    private SaleService saleService;

    public ShoppingCartServiceImpl(LaptopService laptopService, SaleService saleService) {
        this.laptopService = laptopService;
        this.saleService = saleService;
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

    @Override
    public void emptyCart() {
        cartItems.clear();
    }

    @Override
    public void submitPurchase() {
        Sale sale = new Sale();

        Iterator<CartItem> itemIterator = cartItems.iterator();

        while (itemIterator.hasNext()){
            CartItem item = itemIterator.next();
            SoldLaptop soldLaptop = new SoldLaptop();
            soldLaptop.setLaptop(item.getLaptop());
            soldLaptop.setPriceUnit(item.getPriceUnit());
            soldLaptop.setQuantity(item.getQuantity());
            soldLaptop.setSubtotal(item.getSubtotal());
            soldLaptop.setSale(sale);
            sale.getSoldLaptops().add(soldLaptop);
        }
        sale.setDate(new Date());
        sale.setSaleAmount(getTotal());
        saleService.save(sale);
        emptyCart();
    }
}
