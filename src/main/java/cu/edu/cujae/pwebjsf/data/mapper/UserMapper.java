package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.User;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "code", target = "code"),
      @org.mapstruct.Mapping(source = "username", target = "username"),
      @org.mapstruct.Mapping(source = "password", target = "password"),
      @org.mapstruct.Mapping(source = "email", target = "email"),
      @org.mapstruct.Mapping(source = "roles", target = "roles"),
      @org.mapstruct.Mapping(source = "recoverCode", target = "recoverCode"),
      @org.mapstruct.Mapping(source = "firstName", target = "firstName"),
      @org.mapstruct.Mapping(source = "lastName", target = "lastName"),
    }
  )
  User toUser(UserDto userDto);

  List<User> toListUser(List<UserDto> users);

  @InheritInverseConfiguration
  UserDto toUserDto(User user);

  List<UserDto> toListUserDto(List<User> users);
}
