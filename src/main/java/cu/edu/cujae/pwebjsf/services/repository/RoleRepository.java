package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.RoleCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Role;
import cu.edu.cujae.pwebjsf.data.mapper.RoleMapper;
import cu.edu.cujae.pwebjsf.services.dto.RoleDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {

  @Autowired
  private RoleCrudRepository roleCrudRepository;

  @Autowired
  private RoleMapper roleMapper;

  public List<RoleDto> getAll() {
    List<Role> roles = (List<Role>) roleCrudRepository.findAll();
    return roleMapper.toListRoleDto(roles);
  }

  public RoleDto getByCode(Integer code) {
    return roleMapper.toRoleDto(roleCrudRepository.findByCode(code));
  }

  public void save(RoleDto role) {
    Role roleEntity = roleMapper.toRole(role);
    roleCrudRepository.save(roleEntity);
  }

  public void delete(Integer code) {
    roleCrudRepository.deleteByCode(code);
  }
}
