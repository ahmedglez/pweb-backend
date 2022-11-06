package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.Role;
import cu.edu.cujae.pwebjsf.services.dto.RoleDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "code", target = "code"),
                    @org.mapstruct.Mapping(source = "role", target = "role"),
                    @org.mapstruct.Mapping(target = "roles", ignore = true),
            }
    )
    Role toRole(RoleDto role);
    List<Role> toListRole(List<RoleDto> roles);

    @InheritInverseConfiguration
    RoleDto toRoleDto(Role role);
    List<RoleDto> toListRoleDto(List<Role> roles);
}
