package com.victorherrera.onlinestoremvcexercise.services.springdatajpa;

import com.victorherrera.onlinestoremvcexercise.model.Sale;
import com.victorherrera.onlinestoremvcexercise.repositories.SaleRepository;
import com.victorherrera.onlinestoremvcexercise.services.SaleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Set<Sale> findAll() {
        Set<Sale> set = new HashSet<>();
        saleRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Sale findById(Long id) {
        Optional<Sale> optionalSale = saleRepository.findById(id);
        return optionalSale.orElse(null);
    }

    @Override
    public Sale save(Sale object) {
        return saleRepository.save(object);
    }

    @Override
    public void delete(Sale object) {
        saleRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }
}
