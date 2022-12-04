package cu.edu.cujae.pwebjsf.data.entity;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "cod_user")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer code;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "email")
  private String email;

  @ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
  @JoinTable(
    name = "users_roles",
    joinColumns = {
      @JoinColumn(name = "cod_user"),
    },
    inverseJoinColumns = {
      @JoinColumn(name = "cod_role"),
    }
  )
  private Collection<Role> roles;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Collection<Role> getRoles() {
    return roles;
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = roles;
  }
}
