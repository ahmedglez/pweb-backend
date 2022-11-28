package cu.edu.cujae.pwebjsf.services.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cu.edu.cujae.pwebjsf.data.crud.UserCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.User;
import cu.edu.cujae.pwebjsf.data.mapper.UserMapper;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;

@Repository
public class UserRepository {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserCrudRepository userCrudRepository;

  public List<UserDto> getAll() {
    List<User> users = (List<User>) userCrudRepository.findAll();
    return userMapper.toListUserDto(users);
  }

  public UserDto getById(Integer code) {
    return userMapper.toUserDto(userCrudRepository.findByCode(code));
  }

  public void save(UserDto user) {
    User userEntity = userMapper.toUser(user);
    userCrudRepository.save(userEntity);
  }

  public void delete(Integer code) {
    userCrudRepository.deleteById(code);
  }

  public UserDto exists(UserDto userDto) {
    UserDto user = new UserDto();
    List<UserDto> users = getAll();
    for (int i = 0; i < users.size(); i++) {
      if (
        users.get(i).getUsername().equals(userDto.getUsername()) &&
        users.get(i).getPassword().equals(userDto.getPassword())
      ) {
        user = users.get(i);
        i = users.size();
      }
    }
    return user;
  }

  public UserDto findByUsername(String username) {
    User user = userCrudRepository.findByUsername(username);
    return userMapper.toUserDto(user);
  }
}
