package cu.edu.cujae.pwebjsf.data.entity;

import cu.edu.cujae.pwebjsf.data.utils.UserPK;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(value = UserPK.class)
@Table(name = "users_roles")
public class UserAndRole implements Serializable {

    @Id
    @Column(name = "cod_user")
    private Integer codeUser;

    @Id
    @Column(name = "cod_role")
    private Integer codeRole;

    @ManyToOne
    @JoinColumn(name = "cod_user", updatable = false, insertable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "cod_role", updatable = false, insertable = false)
    private Role role;

    public Integer getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(Integer codeUser) {
        this.codeUser = codeUser;
    }

    public Integer getCodeRole() {
        return codeRole;
    }

    public void setCodeRole(Integer codeRole) {
        this.codeRole = codeRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
