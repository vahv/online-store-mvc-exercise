package com.victorherrera.onlinestoremvcexercise.services.springdatajpa;

import com.victorherrera.onlinestoremvcexercise.model.Laptop;
import com.victorherrera.onlinestoremvcexercise.repositories.LaptopRepository;
import com.victorherrera.onlinestoremvcexercise.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class LaptopServiceImpl implements LaptopService {
    LaptopRepository laptopRepository;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public Laptop findByModel(String model) {
        Optional<Laptop> optionalLaptop = laptopRepository.findByModel(model);
        return optionalLaptop.orElse(null);
    }

    @Override
    public Set<Laptop> findAll() {
        Set<Laptop> laptops = new HashSet<>();
        laptopRepository.findAll().forEach(laptops::add);
        return laptops;
    }

    @Override
    public Laptop findById(Long id) {
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        return optionalLaptop.orElse(null);
    }

    @Override
    public Laptop save(Laptop object) {
        return laptopRepository.save(object);
    }

    @Override
    public void delete(Laptop object) {
        laptopRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        laptopRepository.deleteById(id);
    }
}
