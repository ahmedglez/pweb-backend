package cu.edu.cujae.pwebjsf.services.dto;

public class CarModelDto {
	private int model_code;
	private String model;
	private BrandDto brand;

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

	public BrandDto getBrand() {
		return brand;
	}

	public void setBrand(BrandDto brand) {
		this.brand = brand;
	}
	
	
	
}
