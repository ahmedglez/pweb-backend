package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver_category")
public class Driver_Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "cod_category")
  private int code;

  @Column(name = "category")
  private String category;

  @OneToOne(mappedBy = "category")
  private Driver driver;

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

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  /* GETTERS AND SETTERS */

  
}
