package cu.edu.cujae.pwebjsf.data.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "car_model")
public class Car_Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cod_model")
  private int codeModel;

  @Column(name = "model")
  private String model;

  @Column(name = "cod_brand")
  private int cod_brand;

  @ManyToOne
  @JoinColumn(name = "cod_brand", insertable = false, updatable = false)
  private Car_Brand brand;

  @OneToMany(mappedBy = "carModel")
  private List<Car> cars;

  //	Setters and Getters
  public int getCodeModel() {
    return codeModel;
  }

  public void setCodeModel(int codeModel) {
    this.codeModel = codeModel;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getCod_brand() {
    return this.cod_brand;
  }

  public void setCod_brand(Integer cod_brand) {
    this.cod_brand = cod_brand;
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
