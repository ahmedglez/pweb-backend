package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.RoleDto;
import cu.edu.cujae.pwebjsf.services.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServices {

  @Autowired
  private RoleRepository roleRepository;

  public List<RoleDto> getAll() {
    System.out.printf("RoleServices.getAll", roleRepository.getAll());
    return roleRepository.getAll();
  }

  public RoleDto getById(Integer code) {
    return roleRepository.getByCode(code);
  }

  public void save(RoleDto role) {
    roleRepository.save(role);
  }

  public void delete(Integer code) {
    roleRepository.delete(code);
  }
}
