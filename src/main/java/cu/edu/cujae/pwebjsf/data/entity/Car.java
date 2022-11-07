package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
	
	@Id
	@Column(name = "cod_car")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeCar;
	
	@Column(name = "car_id")
	private String plate;
	
	@ManyToOne
	@JoinColumn(name = "cod_status", insertable = false, updatable = false)
	private Car_Status status;
	
	@Column(name = "cod_status")
	private int statusCode;
	
	@ManyToOne
	@JoinColumn(name = "cod_brand", insertable = false, updatable = false)
	private Car_Brand brand;	
	
	@Column(name = "cod_brand")
	private int brandCode;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "km_driver")
	private double mileage;

	
//	Getters and Setters
	public int getCodeCar() {
		return codeCar;
	}

	public void setCodeCar(int codeCar) {
		this.codeCar = codeCar;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public Car_Status getStatus() {
		return status;
	}

	public void setStatus(Car_Status status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Car_Brand getBrand() {
		return brand;
	}

	public void setBrand(Car_Brand brand) {
		this.brand = brand;
	}

	public int getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(int brandCode) {
		this.brandCode = brandCode;
	}


}
