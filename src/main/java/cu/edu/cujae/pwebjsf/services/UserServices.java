package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import cu.edu.cujae.pwebjsf.services.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll(){return userRepository.getAll();}

    public UserDto getById(Integer code){return userRepository.getById(code);}

    public void save(UserDto user){userRepository.save(user);}

    public void delete (Integer code){userRepository.delete(code);}

    public UserDto isUser(UserDto user){return userRepository.exists(user);}

}