package com.orderPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderPopulation.Entity.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Long>{

}
