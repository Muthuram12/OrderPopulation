package com.orderPopulation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderPopulation.Entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{

}
