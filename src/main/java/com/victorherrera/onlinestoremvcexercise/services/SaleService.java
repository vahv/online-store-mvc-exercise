package com.victorherrera.onlinestoremvcexercise.services;

import com.victorherrera.onlinestoremvcexercise.model.Sale;

import java.util.Set;

public interface SaleService {
    Set<Sale> findAll();
    Sale findById(Long id);
    Sale save(Sale object);
    void delete(Sale object);
    void deleteById(Long id);
}
