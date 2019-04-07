package com.fdm.jdbc.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="PIG")
public class Pig implements Persistable<Pig>{
	
	@Id
	private int id;
	private String name;
	private double weight;
	

	//Has to be present for JPA to work
	//Has to have getters and setter for all field
	public Pig() {}
	
	public void update(Pig updateValue) {
		if(id == updateValue.id) {
			name = updateValue.name;
			weight = updateValue.weight;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
