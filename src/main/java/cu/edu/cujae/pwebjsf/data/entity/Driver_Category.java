package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver_category")
public class Driver_Category {

  @Id
  @Column(name = "cod_category")
  private int code;

  @Column(name = "category")
  private String category;
}
