package cu.edu.cujae.pwebjsf.services.dto;

public class CarModelDto {
	private int model_code;
	private String model;
	
	public CarModelDto(int model_code, String model) {
		super();
		this.model_code = model_code;
		this.model = model;
	}

	public int getModel_code() {
		return model_code;
	}

	public void setModel_code(int model_code) {
		this.model_code = model_code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
