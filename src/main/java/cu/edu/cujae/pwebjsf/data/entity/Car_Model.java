package cu.edu.cujae.pwebjsf.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Car_Brand brands;


	
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

	public Car_Brand getBrands() {
		return brands;
	}

	public void setBrands(Car_Brand brands) {
		this.brands = brands;
	}
	
	

}
