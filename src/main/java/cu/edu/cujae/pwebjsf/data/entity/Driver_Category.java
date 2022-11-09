package cu.edu.cujae.pwebjsf.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "driver_category")
public class Driver_Category {

  @Id
  @Column(name = "cod_category")
  private int code;

  @Column(name = "category")
  private String category;

  @OneToMany(mappedBy = "category")
  private List<Driver> drivers;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public List<Driver> getDrivers() {
    return drivers;
  }

  public void setDrivers(List<Driver> drivers) {
    this.drivers = drivers;
  }

  
}
