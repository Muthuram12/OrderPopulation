package com.orderPopulation.RestController;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orderPopulation.Entity.OrderHeader;
import com.orderPopulation.Exception.OrderNotFoundException;
import com.orderPopulation.Service.OrderHeaderService;



@RequestMapping("api/ordersHeader")
@RestController
public class OrderHeaderController {
	public static Logger log=Logger.getLogger(OrderHeaderController.class);
	@Autowired
	OrderHeaderService theOrderHeaderService;
	
	@PostMapping("/save")
	
	public ResponseEntity<OrderHeader> createOrders(@RequestBody OrderHeader header) {
		return theOrderHeaderService.createOrder(header);
	}
	@GetMapping("/get")
	public List<OrderHeader> getAllOrder() throws OrderNotFoundException{
		return theOrderHeaderService.getAllOrder();
	}
	
	@GetMapping("/getOrder/{id}")
	public OrderHeader getOrderById(@PathVariable long id) throws OrderNotFoundException {
		return theOrderHeaderService.getOrderById(id);
	}
	@PutMapping("/update/{id}")
	public OrderHeader update(@PathVariable long id,@RequestBody OrderHeader orderHeader) throws OrderNotFoundException {
		return theOrderHeaderService.update(id, orderHeader);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteByOrderNO(@PathVariable long id )  {
		return theOrderHeaderService.deleteByOrderNO(id);
	}
	
	

}
