package com.javashark.hibernate.cars;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="car")
public class Cars {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name_car")
	private String name_car;
	
	@Column(name="model_car")
	private String name_model;
	 
	@OneToMany(mappedBy="carObject", cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
     private List<Color> colorList;
    
 // constructor by defaults
	public Cars() {
	
	}

  // constructor with parameters

	public Cars(String name_car, String name_model) {
	
		this.name_car = name_car;
		this.name_model = name_model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName_car() {
		return name_car;
	}

	public void setName_car(String name_car) {
		this.name_car = name_car;
	}

	public String getName_model() {
		return name_model;
	}

	public void setName_model(String name_model) {
		this.name_model = name_model;
	}

	@Override
	public String toString() {
		return "Cars [id=" + id + ", name_car=" + name_car + ", name_model="
				+ name_model + "]";
	}

	public List<Color> getColorList() {
		return colorList;
	}

	public void setColorList(List<Color> colorList) {
		this.colorList = colorList;
	}

	
   public void addColors(Color color){
	   if (color == null){
		   colorList.add(color);
	   }
	   color.setCarObject(this);
   }
	
	
	
	
	
	
	

}
