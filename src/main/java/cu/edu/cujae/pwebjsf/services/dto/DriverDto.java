package cu.edu.cujae.pwebjsf.services.dto;

public class DriverDto {

  private int code;
  private String id;
  private String name;
  private String lastName;
  private String address;
  private DriversCategoriesDto category;

  public DriverDto(
    int code,
    String id,
    String name,
    String lastName,
    String address,
    
    DriversCategoriesDto category
  ) {
    this.code = code;
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.category = category;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
