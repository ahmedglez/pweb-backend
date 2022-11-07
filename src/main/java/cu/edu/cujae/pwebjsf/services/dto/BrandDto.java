package cu.edu.cujae.pwebjsf.services.dto;

public class BrandDto {

	private int cod_brand;
    private String brand;
    private CarModelDto model;
    
    public BrandDto(int cod_brand, String brand, CarModelDto model) {
        super();
        this.cod_brand = cod_brand;
        this.brand = brand;
        this.model = model;
    }

	public int getCod_brand() {
		return cod_brand;
	}

	public void setCod_brand(int cod_brand) {
		this.cod_brand = cod_brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public CarModelDto getModel() {
		return model;
	}

	public void setModel(CarModelDto model) {
		this.model = model;
	}

	
    
    
	
}
