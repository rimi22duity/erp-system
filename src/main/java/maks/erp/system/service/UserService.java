package maks.erp.system.service;

import maks.erp.system.dto.UserDto;
import maks.erp.system.model.user.User;
import maks.erp.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .joiningDate(user.getJoiningDate())
                .username(user.getUsername())
                .password(user.getPassword())
                .salary(user.getSalary())
                .build();
    }

    public List<UserDto> getUserList() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.stream().forEach((user) -> {
            userDtos.add(mapToUserDto(user));
        });

        return userDtos;
    }

    public UserDto findUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()) {
            User dbUser = optional.get();
            return mapToUserDto(dbUser);
        }

        return null;
    }
}
