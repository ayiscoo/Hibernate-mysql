package com.javashark.hibernate.cars;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@Entity
@Table(name="color")
public class Color {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="color")
	private String color;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="car_id")
	private Cars carObject;
	
	public Color() {
	
	}

	public Color(String color) {		
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", color=" + color + "]";
	}

	public Cars getCarObject() {
		return carObject;
	}

	public void setCarObject(Cars carObject) {
		this.carObject = carObject;
	}

	
	
	
	
	
}
