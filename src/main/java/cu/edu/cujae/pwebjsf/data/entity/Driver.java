package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver {

  @Id
  @Column(name = "cod_driver")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int code;

  @Column(name = "id")
  private String ci;

  @Column(name = "name")
  private String name;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "address")
  private String address;

  @Column(name = "cod_category")
  private int categoryCode;

  @ManyToOne
  @JoinColumn(name = "cod_category", insertable = false, updatable = false)
  private Driver_Category category;

  @OneToMany(mappedBy = "driver")
  private List<Contract> contracts;

  /* GETTERS AND SETTERS */
  public int getCode() {
    return this.code;
  }

  public void setCode(int codeDriver) {
    this.code = codeDriver;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String last_name) {
    this.lastName = last_name;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getCod_category() {
    return this.categoryCode;
  }

  public void setCod_category(int cod_category) {
    this.categoryCode = cod_category;
  }

  public int getCategoryCode() {
    return categoryCode;
  }

  public void setCategoryCode(int categoryCode) {
    this.categoryCode = categoryCode;
  }

  public Driver_Category getCategory() {
    return category;
  }

  public void setCategory(Driver_Category category) {
    this.category = category;
  }

  public String getCi() {
    return ci;
  }

  public void setCi(String ci) {
    this.ci = ci;
  }

  public List<Contract> getContracts() {
    return contracts;
  }

  public void setContracts(List<Contract> contracts) {
    this.contracts = contracts;
  }
}
