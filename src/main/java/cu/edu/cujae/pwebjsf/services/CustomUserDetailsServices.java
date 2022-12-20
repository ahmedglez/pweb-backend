package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.RoleDto;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServices implements UserDetailsService {

  @Autowired
  private UserServices service;

  private ArrayList<GrantedAuthority> getGrantedAuthorities(
    Collection<RoleDto> collection
  ) throws UsernameNotFoundException {
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    for (RoleDto role : collection) {
      authorities.add(role::getRole);
    }
    return authorities;
  }

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    /* password with BCryptPasswordEncoder encoding */
    UserDto user = service.getUserByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new User(
      user.getUsername(),
      "{noop}" + user.getPassword(),
      getGrantedAuthorities(user.getRoles())
    );
  }
}
