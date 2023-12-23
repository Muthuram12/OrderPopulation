package com.orderPopulation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customerAddress")
public class CustomerAddress {
	
	@Id
	private long customer_address_id;

	public long getCustomer_address_id() {
		return customer_address_id;
	}

	public void setCustomer_address_id(long customer_address_id) {
		this.customer_address_id = customer_address_id;
	}

}
