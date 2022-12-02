package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.RoleDto;
import cu.edu.cujae.pwebjsf.services.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices {

    @Autowired
    RoleRepository roleRepository;

    public List<RoleDto> getAll(){return roleRepository.getAll();}

    public RoleDto getById(int code){return roleRepository.getById(code);}

    public void save(RoleDto role){ roleRepository.save(role);}

    public void delete(int code){roleRepository.delete(code);}

}
