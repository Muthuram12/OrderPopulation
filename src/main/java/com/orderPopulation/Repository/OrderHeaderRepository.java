package com.orderPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderPopulation.Entity.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long>{

}
