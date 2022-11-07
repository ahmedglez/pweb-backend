package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car_model")
public class Car_Model {
	
	@Id
	@Column(name = "cod_model")
	private int codeModel;
	
	@Column(name = "model")
	private String model;
	
	@ManyToOne
	@JoinColumn(name = "model", insertable = false, updatable = false)
	private Car_Brand brand_2;


	
//	Setters and Getters
	public int getCodeModel() {
		return codeModel;
	}

	public void setCodeModel(int codeModel) {
		this.codeModel = codeModel;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Car_Brand getBrand() {
		return brand_2;
	}

	public void setBrand(Car_Brand brand) {
		this.brand_2 = brand;
	}

	
	
	

}
