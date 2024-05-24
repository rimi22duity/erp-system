package maks.erp.system.service;

import maks.erp.system.dto.UserDto;
import maks.erp.system.model.user.User;
import maks.erp.system.model.user.UserDocument;
import maks.erp.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDocumentService userDocumentService;

    @Autowired
    private DesignationService designationService;

    @Autowired
    private AddressService addressService;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveNewUser(UserDto userDto) throws IOException {
        UserDocument userDocument = new UserDocument();
        userDocument.setDocument(userDto.getDocument().getBytes());
        userDocument.setFileName(userDto.getDocument().getOriginalFilename());

        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .birthDate(userDto.getBirthDate())
                .joiningDate(userDto.getJoiningDate())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .salary(userDto.getSalary())
                .userDocument(userDocument)
                .build();

        userDocumentService.save(userDocument);
        designationService.save(userDto.getDesignationDto());
        addressService.save(userDto.getPermanentAddress());
        addressService.save(userDto.getPresentAddress());

        saveUser(user);
    }

    public Optional<User> getUserByUserName(String userName) {
        return userRepository.getUserByUsername(userName);
    }
}
