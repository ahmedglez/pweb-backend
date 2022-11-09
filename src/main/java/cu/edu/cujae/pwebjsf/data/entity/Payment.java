package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

  @Id
  @Column(name = "cod_payment")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int cod_payment;

  @Column(name = "payment")
  private String payment;

  public int getCod_payment() {
    return this.cod_payment;
  }

  public void setCod_payment(int cod_payment) {
    this.cod_payment = cod_payment;
  }

  public String getPayment() {
    return this.payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }
}
