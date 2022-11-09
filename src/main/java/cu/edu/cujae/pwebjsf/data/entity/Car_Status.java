package cu.edu.cujae.pwebjsf.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car_status")
public class Car_Status {
	
	@Id
	@Column(name = "cod_status")
	private int code;

	@Column(name ="status")
	private String status;
	
	@OneToMany(mappedBy = "status")
	private List<Car> cars;

		
//	Setters and Getters
	public void setCode(int codeStatus) {
		this.code = codeStatus;
	}

	public int getCode() {
		return code;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	

}
