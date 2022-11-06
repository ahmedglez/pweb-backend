package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.UserAndRole;
import cu.edu.cujae.pwebjsf.services.dto.UserAndRoleDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAndRoleMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "user.code", target = "codeUser"),
                    @org.mapstruct.Mapping(source = "role.code", target = "codeRole"),
                    @org.mapstruct.Mapping(source = "user", target = "user"),
                    @org.mapstruct.Mapping(source = "role", target = "role"),
            }
    )
    UserAndRole toUserAndRole(UserAndRoleDto userAndRoleDto);
    List<UserAndRole> toListUserAndRole(List<UserAndRoleDto> userAndRoles);

    @InheritInverseConfiguration
    //@Mapping(target = "user")
    //@Mapping(target = "role")
    UserAndRoleDto toUserAndRoleDto(UserAndRole userAndRole);
    List<UserAndRoleDto> toListUserAndRoleDto(List<UserAndRole> userAndRoles);

}
