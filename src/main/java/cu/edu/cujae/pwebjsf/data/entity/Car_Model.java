package cu.edu.cujae.pwebjsf.data.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "car_model")
public class Car_Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cod_model")
  private int code;

  @Column(name = "model")
  private String model;

  @Column(name = "cod_brand")
  private int codeBrand;

  @ManyToOne
  @JoinColumn(name = "cod_brand", insertable = false, updatable = false)
  private Car_Brand brand;

  @OneToMany(mappedBy = "model")
  private List<Car> cars;

  //	Setters and Getters
  public int getCode() {
    return code;
  }

  public void setCode(int codeModel) {
    this.code = codeModel;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getCodeBrand() {
    return this.codeBrand;
  }

  public void setCodeBrand(Integer cod_brand) {
    this.codeBrand = cod_brand;
  }

  public Car_Brand getBrand() {
    return this.brand;
  }

  public void setBrand(Car_Brand brand) {
    this.brand = brand;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }
}
