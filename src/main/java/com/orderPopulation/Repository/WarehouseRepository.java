package com.orderPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderPopulation.Entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
