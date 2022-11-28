package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.RoleCrudRepository;
import cu.edu.cujae.pwebjsf.data.crud.UserAndRoleCrudRepository;
import cu.edu.cujae.pwebjsf.data.crud.UserCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Role;
import cu.edu.cujae.pwebjsf.data.entity.User;
import cu.edu.cujae.pwebjsf.data.entity.UserAndRole;
import cu.edu.cujae.pwebjsf.data.mapper.RoleMapper;
import cu.edu.cujae.pwebjsf.data.mapper.UserAndRoleMapper;
import cu.edu.cujae.pwebjsf.data.mapper.UserMapper;
import cu.edu.cujae.pwebjsf.data.utils.UserPK;
import cu.edu.cujae.pwebjsf.services.dto.UserAndRoleDto;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  @Autowired
  private UserAndRoleCrudRepository userAndRoleCrudRepository;

  @Autowired
  private UserAndRoleMapper userAndRoleMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserCrudRepository userCrudRepository;

  @Autowired
  private RoleMapper roleMapper;

  @Autowired
  private RoleCrudRepository roleCrudRepository;

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
    for (Role role : userEntity.getRoles()) {
      UserAndRole userAndRole = new UserAndRole();
      userAndRole.setUser(userEntity);
      userAndRole.setRole(role);
      userAndRoleCrudRepository.save(userAndRole);
    }
  }

  public void delete(Integer code) {
    UserAndRole userAndRoleEntity = userAndRoleCrudRepository.getByCodeUser(
      code
    );
    userAndRoleCrudRepository.delete(userAndRoleEntity);

    User userEntity = userCrudRepository.findByCode(code);

    userCrudRepository.delete(userEntity);
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
    UserDto user = new UserDto();
    List<UserDto> users = getAll();
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        user = users.get(i);
        i = users.size();
      }
    }
    return user;
  }
}
