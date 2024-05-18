package maks.erp.system.service;

import maks.erp.system.model.dto.UserDto;
import maks.erp.system.model.user.User;
import maks.erp.system.model.user.UserDocument;
import maks.erp.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDocumentService userDocumentService;

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
        saveUser(user);
    }
}
