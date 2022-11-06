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
@Table(name = "car_brand")
public class Car_Brand {
	
	  @Id
	  @Column(name = "cod_brand")
	  private int codeBrand;

	  @Column(name = "brand")
	  private String brand;
	  
	  @OneToMany
	  private List<Car_Model> cod_model;
				
	  @Column(name = "cod_model")
	  private int modelCode;
	  
	  @OneToMany(mappedBy = "brand")
	  private List<Car> cars;
	  
//	  Setter and Getters

	public int getCodeBrand() {
		return codeBrand;
	}

	public void setCodeBrand(int codeBrand) {
		this.codeBrand = codeBrand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car_Model> getCod_model() {
		return cod_model;
	}

	public void setCod_model(List<Car_Model> cod_model) {
		this.cod_model = cod_model;
	}

	public int getModelCode() {
		return modelCode;
	}

	public void setModelCode(int modelCode) {
		this.modelCode = modelCode;
	}
	  
	
	  

}
