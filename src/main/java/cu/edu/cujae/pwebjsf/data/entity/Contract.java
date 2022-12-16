package cu.edu.cujae.pwebjsf.data.entity;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {

  @Id
  @Column(name = "cod_contract")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int code;

  @Column(name = "cod_tourist")
  private int touristCode;

  @ManyToOne
  @JoinColumn(name = "cod_tourist", insertable = false, updatable = false)
  private Tourist tourist;

  @Column(name = "cod_car")
  private int carCode;

  @ManyToOne
  @JoinColumn(name = "cod_car", insertable = false, updatable = false)
  private Car car;

  @Column(name = "cod_driver")
  private Integer driverCode;

  @ManyToOne
  @JoinColumn(name = "cod_driver", insertable = false, updatable = false)
  private Driver driver;

  @Column(name = "cod_bill")
  private int billCode;

  @ManyToOne
  @JoinColumn(name = "cod_bill",insertable = false, updatable = false)
  private Bill bill;

  @Column(name = "cod_payment")
  private int paymentCode;

  @ManyToOne
  @JoinColumn(name = "cod_payment",insertable = false, updatable = false)
  private Payment payment;

  @Column(name = "date_start")
  private LocalDate startingDate;

  @Column(name = "date_final")
  private LocalDate finalDate;

  @Column(name = "extension")
  private int extension;

  @Column(name = "total_amount")
  private int totalAmount;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public LocalDate getFinalDate() {
    return finalDate;
  }

  public void setFinalDate(LocalDate finalDate) {
    this.finalDate = finalDate;
  }

  public int getExtension() {
    return extension;
  }

  public void setExtension(int extension) {
    this.extension = extension;
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
  }

  public LocalDate getStartingDate() {
    return startingDate;
  }

  public void setStartingDate(LocalDate startingDate) {
    this.startingDate = startingDate;
  }

  public Tourist getTourist() {
    return tourist;
  }

  public void setTourist(Tourist tourist) {
    this.tourist = tourist;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  public Bill getBill() {
    return bill;
  }

  public void setBill(Bill bill) {
    this.bill = bill;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public int getTouristCode() {
    return touristCode;
  }

  public void setTouristCode(int touristCode) {
    this.touristCode = touristCode;
  }

  public int getCarCode() {
    return carCode;
  }

  public void setCarCode(int carCode) {
    this.carCode = carCode;
  }

  public Integer getDriverCode() {
    return driverCode;
  }

  public void setDriverCode(Integer driverCode) {
    this.driverCode = driverCode;
  }

  public int getBillCode() {
    return billCode;
  }

  public void setBillCode(int billCode) {
    this.billCode = billCode;
  }

  public int getPaymentCode() {
    return paymentCode;
  }

  public void setPaymentCode(int paymentCode) {
    this.paymentCode = paymentCode;
  }
}
