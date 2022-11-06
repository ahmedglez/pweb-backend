package cu.edu.cujae.pwebjsf.services.dto;

public class BrandDto {

	private int cod_brand;
    private String brand;
    private CarModelDto cod_model;
    
    public BrandDto(int cod_brand, String brand, CarModelDto cod_model) {
        super();
        this.cod_brand = cod_brand;
        this.brand = brand;
        this.cod_model = cod_model;
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

	public CarModelDto getCod_model() {
		return cod_model;
	}

	public void setCod_model(CarModelDto cod_model) {
		this.cod_model = cod_model;
	}
    
    
	
}
