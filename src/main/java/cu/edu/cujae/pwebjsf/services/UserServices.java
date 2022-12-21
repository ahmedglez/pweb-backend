package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import cu.edu.cujae.pwebjsf.services.repository.UserRepository;
import cu.edu.cujae.pwebjsf.utils.PasswordEncoderUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

  private PasswordEncoderUtils passwordEncoderUtils = new PasswordEncoderUtils();

  @Autowired
  private UserRepository userRepository;


  public List<UserDto> getAll() {
    return userRepository.getAll();
  }

  public UserDto getById(Integer code) {
    return userRepository.getByCode(code);
  }

  public void save(UserDto user) {
    userRepository.save(user);
  }

  public void delete(Integer code) {
    userRepository.delete(code);
  }

  public UserDto getUserByUsername(String username) {
    return userRepository.getUserByUsername(username);
  }

  public UserDto isUser(UserDto user) {
    return userRepository.exists(user);
  }

  public UserDto login(UserDto user) {
    return userRepository.login(user);
  }

  public UserDto getUserByEmail(String email) {
    return userRepository.getUserByEmail(email);
  }

  public UserDto findByUserName(String userName) {
    return userRepository.findByUserName(userName);
  }
}
