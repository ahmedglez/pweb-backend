package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @Column(name = "cod_contract")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @Column(name="cod_tourist")
    private int codeTourist;

    @Column(name = "cod_car")
    private int codeCar;

    @Column(name = "cod_driver")
    private Integer codeDriver;

    @Column(name = "cod_bill")
    private int codeBill;

    @Column(name = "cod_payment")
    private int codePayment;

    @Column(name = "date_start")
    private LocalDate startingDate;

    @Column(name = "date_final")
    private LocalDate finalDate;

    @Column(name = "extension")
    private int extension;

    @Column(name = "total_amount")
    private int totalAmount;

    @ManyToOne
    @JoinColumn(name = "cod_tourist", insertable = false, updatable = false)
    private Tourist tourist;

    @ManyToOne
    @JoinColumn(name = "cod_car", insertable = false, updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "cod_driver", insertable = false, updatable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "cod_bill", insertable = false, updatable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "cod_payment", insertable = false, updatable = false)
    private Payment payment;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCodeTourist() {
        return codeTourist;
    }

    public void setCodeTourist(int codeTourist) {
        this.codeTourist = codeTourist;
    }

    public int getCodeCar() {
        return codeCar;
    }

    public void setCodeCar(int codeCar) {
        this.codeCar = codeCar;
    }

    public int getCodeDriver() {
        return codeDriver;
    }

    public void setCodeDriver(int codeDriver) {
        this.codeDriver = codeDriver;
    }

    public int getCodeBill() {
        return codeBill;
    }

    public void setCodeBill(int codeBill) {
        this.codeBill = codeBill;
    }

    public int getCodePayment() {
        return codePayment;
    }

    public void setCodePayment(int codePayment) {
        this.codePayment = codePayment;
    }

    public LocalDate getInitDate() {
        return startingDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.startingDate = initDate;
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

    public void setCodeDriver(Integer codeDriver) {
        this.codeDriver = codeDriver;
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
}
