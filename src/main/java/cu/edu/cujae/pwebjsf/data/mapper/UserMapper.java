package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.User;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "code", target = "code"),
                    @org.mapstruct.Mapping(source = "name", target = "name"),
                    @org.mapstruct.Mapping(source = "password", target = "password"),
                    @org.mapstruct.Mapping(target = "users", ignore = true),

            }
    )
    User toUser(UserDto userDto);

    List<User> toListUser(List<UserDto> users);

    @InheritInverseConfiguration
    UserDto toUserDto(User user);

    List<UserDto> toListUserDto(List<User> users);


}
