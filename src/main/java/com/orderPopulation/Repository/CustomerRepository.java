package com.orderPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderPopulation.Entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
