package com.orderPopulation.ServiceImpl;


import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.orderPopulation.Entity.OrderHeader;
import com.orderPopulation.Exception.OrderNotFoundException;
import com.orderPopulation.Repository.OrderHeaderRepository;
import com.orderPopulation.Service.OrderHeaderService;

@Service
public class OrderHeaderServiceImpl implements OrderHeaderService {
	public static Logger log=Logger.getLogger(OrderHeaderServiceImpl.class);
	@Autowired
 private OrderHeaderRepository theOrderHeaderRepository;

	@Override
	public ResponseEntity<OrderHeader> createOrder(OrderHeader header) {
		PropertyConfigurator.configure("Log.property");
		if(header != null) {
		log.info("Create Order SuccessFully");
		return  ResponseEntity.ok(header);
		}
		else {
			log.error("Cannot create order. Input parameter 'header' is null.");
			throw new NullPointerException("Header cannot be null");
		}
		
	}

	@Override
	public List<OrderHeader> getAllOrder() throws OrderNotFoundException {
		PropertyConfigurator.configure("Log.property");
		List<OrderHeader> orderHeaders =theOrderHeaderRepository.findAll();
		
	if(orderHeaders.isEmpty()) {
		log.warn("No orders Found");
		throw new OrderNotFoundException("No orders Found");
	}
	log.info("Successfully retrieved OrderHeader details.");
	return orderHeaders;
	}

	@Override
	public OrderHeader getOrderById(long id) throws OrderNotFoundException  {
		PropertyConfigurator.configure("Log.property");
		Optional<OrderHeader> orderHeader=theOrderHeaderRepository.findById(id);
		if(orderHeader.isPresent()) {
		log.info("Successfully Get the OrderHeader detail By Order number");
		return orderHeader.get();
		}
		else {
			log.error("Order Not Found with "+id+" Order Number.");
			throw new OrderNotFoundException("Order Not Found with "+id+" Order Number.");
		}
	}
	
	@Override
	public String deleteByOrderNO(long id) {
		PropertyConfigurator.configure("Log.property");
		log.info("Successfully deleted order details");
		theOrderHeaderRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public OrderHeader update(long id, OrderHeader orderHeader) throws OrderNotFoundException {
		PropertyConfigurator.configure("Log.property");
	Optional<OrderHeader> orderHeaderUpdate=theOrderHeaderRepository.findById(id);
		if(orderHeaderUpdate.isPresent()) {
			OrderHeader orderToUpdate=orderHeaderUpdate.get();
		
			orderToUpdate.setBuild(orderHeader.getBuild());
			orderToUpdate.setOrder_date(orderHeader.getOrder_date());
			orderToUpdate.setOrderDetails(orderHeader.getOrderDetails());
			log.info("Successfully update the Order detail.");
		return theOrderHeaderRepository.save(orderToUpdate);
		}
		else {
			log.error("Order Not Found with "+id+" Order Number.");
			throw new OrderNotFoundException("Order Not Found with "+id+" Order Number.");
		}
	}

	

}








