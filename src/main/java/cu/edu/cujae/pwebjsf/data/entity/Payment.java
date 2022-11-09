package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {

  @Id
  @Column(name = "cod_payment")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int code;

  @Column(name = "payment")
  private String payment;

  @OneToMany(mappedBy = "payment")
  private List<Contract> contracts;

  public int getCode() {
    return this.code;
  }

  public void setCode(int cod_payment) {
    this.code = cod_payment;
  }

  public String getPayment() {
    return this.payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }

  public List<Contract> getContracts() {
    return contracts;
  }

  public void setContracts(List<Contract> contracts) {
    this.contracts = contracts;
  }
}
