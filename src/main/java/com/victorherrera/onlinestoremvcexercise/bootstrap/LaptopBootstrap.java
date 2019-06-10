package com.victorherrera.onlinestoremvcexercise.bootstrap;

import com.victorherrera.onlinestoremvcexercise.model.Sale;
import com.victorherrera.onlinestoremvcexercise.model.SoldLaptop;
import com.victorherrera.onlinestoremvcexercise.repositories.LaptopRepository;
import com.victorherrera.onlinestoremvcexercise.repositories.SaleRepository;
import com.victorherrera.onlinestoremvcexercise.repositories.SoldLaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LaptopBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private LaptopRepository laptopRepository;
    private SaleRepository saleRepository;
    private SoldLaptopRepository soldLaptopRepository;

    @Autowired
    public LaptopBootstrap(LaptopRepository laptopRepository, SaleRepository saleRepository, SoldLaptopRepository soldLaptopRepository) {
        this.laptopRepository = laptopRepository;
        this.saleRepository = saleRepository;
        this.soldLaptopRepository = soldLaptopRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){
        Sale sale = new Sale();
        sale.setSaleAmount(100.0);
        sale.setDate(new Date());
        SoldLaptop soldLaptop = new SoldLaptop();
        soldLaptop.setPriceUnit(100.0);
        soldLaptop.setSubtotal(100.0);
        soldLaptop.setQuantity(1);
        soldLaptop.setLaptop(laptopRepository.findById(Long.parseLong("1")).orElse(null));
        soldLaptop.setSale(sale);
        sale.getSoldLaptops().add(soldLaptop);
        saleRepository.save(sale);

    }
}
