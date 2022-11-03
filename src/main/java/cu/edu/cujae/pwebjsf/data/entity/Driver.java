package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {

  @Id
  @Column(name = "cod_driver")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int codeDriver;

  @Column(name = "id")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "last_name")
  private String last_name;

  @Column(name = "address")
  private String address;

  @Column(name = "cod_category")
  private int categoryCode;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(
    name = "cod_category",
    referencedColumnName = "cod_category",
    insertable = false,
    updatable = false
  )
  private Driver_Category category;

  /* GETTERS AND SETTERS */
  public int getCodeDriver() {
    return this.codeDriver;
  }

  public void setCodeDriver(int codeDriver) {
    this.codeDriver = codeDriver;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLast_name() {
    return this.last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
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
}
