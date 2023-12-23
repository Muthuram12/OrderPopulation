package com.orderPopulation.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.orderPopulation.Entity.OrderHeader;
import com.orderPopulation.Exception.OrderNotFoundException;

public interface OrderHeaderService {

	ResponseEntity<OrderHeader> createOrder(OrderHeader header);

	List<OrderHeader> getAllOrder() throws OrderNotFoundException;

	OrderHeader getOrderById(long order_no) throws OrderNotFoundException;
	
	String deleteByOrderNO(long order_no);

	OrderHeader update(long id, OrderHeader orderHeader) throws OrderNotFoundException;

	

}
