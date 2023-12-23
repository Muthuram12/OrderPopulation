package com.orderPopulation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Building")
public class Building {
	@Id
	private long building_id;

	public long getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(long building_id) {
		this.building_id = building_id;
	}

}
