package com.victorherrera.onlinestoremvcexercise.services;

import com.victorherrera.onlinestoremvcexercise.model.Laptop;

import java.util.Set;

public interface LaptopService {
    Laptop findByModel(String model);
    Set<Laptop> findAll();
    Laptop findById(Long id);
    Laptop save(Laptop object);
    void delete(Laptop object);
    void deleteById(Long id);


}
