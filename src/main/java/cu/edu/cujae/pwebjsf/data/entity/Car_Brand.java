package cu.edu.cujae.pwebjsf.data.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "car_brand")
public class Car_Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cod_brand")
  private int codeBrand;

  @Column(name = "brand")
  private String brand;

  @OneToMany(mappedBy = "brand")
  private List<Car_Model> models;

  


  //	  Setter and Getters

  public int getCodeBrand() {
    return codeBrand;
  }

  public void setCodeBrand(int codeBrand) {
    this.codeBrand = codeBrand;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

public List<Car_Model> getModels() {
	return models;
}

public void setModels(List<Car_Model> models) {
	this.models = models;
}
  

}
