package com.orderPopulation.Service;

import java.util.List;
import java.util.Map;

import com.orderPopulation.Entity.OrderHeader;
import com.orderPopulation.Exception.OrderNotFoundException;

public interface OrderHeaderService {

	String createOrder(OrderHeader header);

	List<OrderHeader> getAllOrder();

	OrderHeader getOrderById(long order_no) throws OrderNotFoundException;


	OrderHeader updateFieldByOrderNo(long order_no, Map<String, Object> m);

	String deleteByOrderNO(long order_no);

	OrderHeader update(long id, OrderHeader orderHeader) throws OrderNotFoundException;

}
