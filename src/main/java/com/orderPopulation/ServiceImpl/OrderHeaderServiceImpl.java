package com.orderPopulation.ServiceImpl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

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
	public String createOrder(OrderHeader header) {
		PropertyConfigurator.configure("Log.property");
		log.debug("Create Order SuccessFully");
		theOrderHeaderRepository.save(header);
		return "Successfully orders created ";
	}

	@Override
	public List<OrderHeader> getAllOrder() {
		PropertyConfigurator.configure("Log.property");
		log.info(theOrderHeaderRepository.findAll());
		log.debug("Successfully Get the OrderHeader details");
		return theOrderHeaderRepository.findAll();
	}

	@Override
	public OrderHeader getOrderById(long id) throws OrderNotFoundException  {
		PropertyConfigurator.configure("Log.property");
		log.debug("Successfully Get the OrderHeader detail By Order number");
		return theOrderHeaderRepository.findById(id).get();	
	}

	@Override
	public OrderHeader updateFieldByOrderNo(long id, Map<String, Object> updates) {
		PropertyConfigurator.configure("Log.property");
		log.debug("Successfully Get the OrderHeader detail By Order number");
		OrderHeader orderHeader=theOrderHeaderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order NOt Found"));
		updates.forEach((fieldName,value)->{
		Field field=ReflectionUtils.findField(OrderHeader.class,fieldName);
		if(field != null) {
			field.setAccessible(true);
		ReflectionUtils.setField(field,orderHeader,value);
		}
		});
		return theOrderHeaderRepository.save(orderHeader);
	}

	@Override
	public String deleteByOrderNO(long id) {
		PropertyConfigurator.configure("Log.property");
		log.debug("Successfully deleted order details");
		theOrderHeaderRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public OrderHeader update(long id, OrderHeader orderHeader) throws OrderNotFoundException {
		OrderHeader orderHeaderUpdate=theOrderHeaderRepository.findById(id).get();
				
		orderHeaderUpdate.setBuild(orderHeader.getBuild());
		orderHeaderUpdate.setOrder_date(orderHeader.getOrder_date());
		orderHeaderUpdate.setOrderDetails(orderHeader.getOrderDetails());
		return theOrderHeaderRepository.save(orderHeaderUpdate);
	}

}








