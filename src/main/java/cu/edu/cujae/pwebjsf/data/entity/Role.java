package cu.edu.cujae.pwebjsf.data.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

  @Id
  @Column(name = "cod_role")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer code;

  @Column(name = "role")
  private String role;

  @Column(name = "description")
  private String description;

  @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "cod_role"),
        inverseJoinColumns = @JoinColumn(name = "cod_user")
    )
  private List<User> users;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

  
}
