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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserDto> getAll(){
        List<UserAndRoleDto> users = userAndRoleMapper.toListUserAndRoleDto(userAndRoleCrudRepository.findAll());
        List<UserDto> result = new ArrayList<>();
        for(UserAndRoleDto e: users){
            e.getUser().setRole(e.getRole());
            result.add(e.getUser());
        }
        return result;
    }

    public UserDto getById(Integer code){
        UserAndRoleDto user = userAndRoleMapper.toUserAndRoleDto(userAndRoleCrudRepository.getByCodeUser(code));
        user.getUser().setRole(user.getRole());
        return user.getUser();
    }

    public void save(UserDto user){
        UserAndRoleDto userDto = new UserAndRoleDto();
        User userEntity = userMapper.toUser(user);
        userDto.setUser(userMapper.toUserDto(userCrudRepository.save(userEntity)));
        Role role = roleMapper.toRole(user.getRole());
        userDto.setRole(roleMapper.toRoleDto(roleCrudRepository.save(role)));
        UserAndRole userAndRoleEntity = userAndRoleMapper.toUserAndRole(userDto);
        userAndRoleCrudRepository.save(userAndRoleEntity);
    }

    public void delete(Integer code){
        UserDto userDto = getById(code);
        UserAndRoleDto user = new UserAndRoleDto();
        user.setUser(userDto);
        user.setRole(userDto.getRole());
        UserAndRole userEntity = userAndRoleMapper.toUserAndRole(user);
        userAndRoleCrudRepository.delete(userEntity);
        userCrudRepository.deleteById(code);

    }

    public UserDto exists(UserDto userDto){
        UserDto user = new UserDto();
        List<UserDto> users = getAll();
        for(int i=0; i < users.size();i++){
            if(users.get(i).getName().equals(userDto.getName()) && users.get(i).getPassword().equals(userDto.getPassword())){
                user = users.get(i);
                i = users.size();
            }
        }
        return user;
    }

}
