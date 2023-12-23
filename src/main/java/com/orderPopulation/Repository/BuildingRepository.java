package com.orderPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderPopulation.Entity.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {

}
