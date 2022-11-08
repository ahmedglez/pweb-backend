package cu.edu.cujae.pwebjsf.services.dto;

public class CarDto {
	private int code ;
	private String carID;
	private String color;
	private CarStatusDto status;
	private ModelDto model;
	private double mileage;
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public CarStatusDto getStatus() {
		return status;
	}

	public void setStatus(CarStatusDto status) {
		this.status = status;
	}

	

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public ModelDto getModel() {
		return model;
	}

	public void setModel(ModelDto model) {
		this.model = model;
	}
	
	

}





