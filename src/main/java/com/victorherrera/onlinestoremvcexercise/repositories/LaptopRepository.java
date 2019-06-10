package com.victorherrera.onlinestoremvcexercise.repositories;

import com.victorherrera.onlinestoremvcexercise.model.Laptop;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LaptopRepository extends CrudRepository<Laptop, Long> {
    Optional<Laptop> findByModel(String model);
}
