package cu.edu.cujae.pwebjsf.services.dto;

import java.util.List;

public class UserDto {

  private int code;
  private String username;
  private String password;
  private String email;
  private boolean enabled;
  private List<RoleDto> roles;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

public List<RoleDto> getRoles() {
    return roles;
}

public void setRoles(List<RoleDto> roles) {
    this.roles = roles;
}
}
