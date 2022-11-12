package cu.edu.cujae.pwebjsf.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
	
	@Id
	@Column(name = "cod_car")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column(name = "car_id")
	private String carID;
	
	@Column(name = "cod_status")
	private int statusCode;

	@ManyToOne
	@JoinColumn(name = "cod_status", insertable = false, updatable = false)
	private Car_Status status;
	
	@Column(name = "cod_model")
	private int modelCode;

	@ManyToOne
	@JoinColumn(name = "cod_model", insertable = false, updatable = false)
	private Car_Model model;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "km_driver")
	private double mileage;

	@OneToMany(mappedBy = "car")
	private List<Contract> contracts;

	
//	Getters and Setters
	public int getCode() {
		return code;
	}

	public void setCode(int codeCar) {
		this.code = codeCar;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String plate) {
		this.carID = plate;
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

	public Car_Model getModel() {
		return model;
	}

	public void setModel(Car_Model carModel) {
		this.model = carModel;
	}

	public int getModelCode() {
		return modelCode;
	}

	public void setModelCode(int modelCode) {
		this.modelCode = modelCode;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

}
