package com.victorherrera.onlinestoremvcexercise.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Double saleAmount;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<SoldLaptop> soldLaptops = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Set<SoldLaptop> getSoldLaptops() {
        return soldLaptops;
    }

    public void setSoldLaptops(Set<SoldLaptop> soldLaptops) {
        this.soldLaptops = soldLaptops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
