package cu.edu.cujae.pwebjsf.services.dto;

public class UserDto {
    private int code;
    private String name;
    private String password;
    private RoleDto role;


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public RoleDto getRole() { return role; }

    public void setRole(RoleDto role) { this.role = role; }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }
}
