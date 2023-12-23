package com.orderPopulation.Entity;

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
@Table(name="order_details")
public class OrderDetails {
	@Id
	
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	   @OneToOne(targetEntity = Warehouse.class,cascade = CascadeType.ALL)
	   @JoinColumn(name="od_warehouse_fk",referencedColumnName = "warehouse_id")
	   private Warehouse ware;
	   
	   
	   @OneToOne(targetEntity = Building.class,cascade = CascadeType.ALL)
	   @JoinColumn(name="od_building_fk",referencedColumnName = "building_id")
	   private Building build;
	
	@Column(name="order_line_no")
	private Long order_line_no;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="order_quantity")
	private Long order_quantity;
	
	public Building getBuild() {
		return build;
	}

	public void setBuild(Building build) {
		this.build = build;
	}

	


	public Long getOrder_line_no() {
		return order_line_no;
	}

	public void setOrder_line_no(Long order_line_no) {
		this.order_line_no = order_line_no;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Warehouse getWare() {
		return ware;
	}

	public void setWare(Warehouse ware) {
		this.ware = ware;
	}

	public Long getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Long order_quantity) {
		this.order_quantity = order_quantity;
	}
	
	 
	
	

}