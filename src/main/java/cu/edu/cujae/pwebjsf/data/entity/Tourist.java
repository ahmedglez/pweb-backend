package cu.edu.cujae.pwebjsf.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tourist")
public class Tourist {

    @Id
    @Column(name = "cod_tourist")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    @Column(name = "passport_id")
    private String idPassport;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "tourist")
    private List<Contract> contracts;

    /* GETTERS AND SETTERS */

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(String passport) {
        this.idPassport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephone) {
        this.telephoneNumber = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
