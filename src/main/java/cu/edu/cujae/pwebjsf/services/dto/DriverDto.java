package cu.edu.cujae.pwebjsf.services.dto;

public class DriverDto {

  private int code;
  private String CI;
  private String name;
  private String lastName;
  private String address;
  private DriversCategoriesDto category;

  public DriverDto(
    int code,
    String CI,
    String name,
    String lastName,
    String address,
    DriversCategoriesDto category
  ) {
    this.code = code;
    this.CI = CI;
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.category = category;
  }

  public String getCI() {
    return CI;
  }

  public void setCI(String CI) {
    this.CI = CI;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public DriversCategoriesDto getCategory() {
    return category;
  }

  public void setCategory(DriversCategoriesDto category) {
    this.category = category;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
