package com.orderPopulation.Entity;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Order_header")
public class OrderHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_no")
	private long order_no;
	
   @OneToOne(targetEntity = Warehouse.class,cascade = CascadeType.ALL)
   @JoinColumn(name="oh_warehouse_fk",referencedColumnName = "warehouse_id")
   private Warehouse ware;
   
   
   @OneToOne(targetEntity = Building.class,cascade = CascadeType.ALL)
   @JoinColumn(name="oh_building_fk",referencedColumnName = "building_id")
   private Building build;
   
   @OneToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
   @JoinColumn(name="oh_customer_fk",referencedColumnName = "customer_id")
   private Customer cus;
   
  
   @OneToOne(targetEntity = CustomerAddress.class,cascade = CascadeType.ALL)
   @JoinColumn(name="oh_customer_address_fk",referencedColumnName = "customer_address_id")
   private CustomerAddress cusAdd;
   
   private LocalDate order_date;
   

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="orderdetail_fk",referencedColumnName = "id")
   private OrderDetails orderDetails;
   
   public long getOrder_no() {
	return order_no;
}

public void setOrder_no(long order_no) {
	this.order_no = order_no;
}

public Warehouse getWare() {
	return ware;
}

public void setWare(Warehouse ware) {
	this.ware = ware;
}

public Building getBuild() {
	return build;
}

public void setBuild(Building build) {
	this.build = build;
}

public Customer getCus() {
	return cus;
}

public void setCus(Customer cus) {
	this.cus = cus;
}

public CustomerAddress getCusAdd() {
	return cusAdd;
}

public void setCusAdd(CustomerAddress cusAdd) {
	this.cusAdd = cusAdd;
}

public LocalDate getOrder_date() {
	return order_date;
}

public OrderDetails getOrderDetails() {
	return orderDetails;
}

public void setOrderDetails(OrderDetails orderDetails) {
	this.orderDetails = orderDetails;
}

public void setOrder_date(LocalDate order_date) {
	this.order_date = order_date;
}

}


