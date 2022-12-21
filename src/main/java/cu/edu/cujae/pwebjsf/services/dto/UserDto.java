package cu.edu.cujae.pwebjsf.services.dto;

import java.util.Collection;

public class UserDto {

  private int code;
  private String username;
  private String password;
  private String email;
  private String recoverCode;
  private String firstName;
  private String lastName;
  private Collection<RoleDto> roles;

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

  public Collection<RoleDto> getRoles() {
    return roles;
  }

  public void setRoles(Collection<RoleDto> roles) {
    this.roles = roles;
  }

  public String getRecoverCode() {
    return recoverCode;
  }

  public void setRecoverCode(String recoverCode) {
    this.recoverCode = recoverCode;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean containRoleAdministrator(){
    for(RoleDto r:roles){
      if(r.getRole().equals("Administrator")){
        return true;
      }
    }
    return false;
  }

}
