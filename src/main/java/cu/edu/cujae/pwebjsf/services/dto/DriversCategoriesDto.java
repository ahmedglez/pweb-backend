package cu.edu.cujae.pwebjsf.services.dto;

public class DriversCategoriesDto {
    private int code;
    private String category;


    public String getCategory() { return category; }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }
}
