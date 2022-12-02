package cu.edu.cujae.pwebjsf.security;



import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServices userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserDto user = null;
		try {
			user = userService.getUserByUserName(username);
			if (user == null) {
	        	throw new UsernameNotFoundException("User not found.");
			}
		} catch (Exception e) {
			user = null;
		}

        return UserPrincipal.create(user);
    }

}