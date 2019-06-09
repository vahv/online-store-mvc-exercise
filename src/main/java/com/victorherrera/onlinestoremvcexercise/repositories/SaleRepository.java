package com.victorherrera.onlinestoremvcexercise.repositories;

import com.victorherrera.onlinestoremvcexercise.model.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Long> {
}
