package maks.erp.system.service;

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

    public void saveUser(User user) { userRepository.save(user); }

    public void saveNewUser(User user, MultipartFile file) throws IOException {
        UserDocument userDocument = new UserDocument();
        userDocument.setDocument(Base64.getEncoder().encodeToString(file.getBytes()));

        user.setUserDocument(userDocument);

        saveUser(user);
    }
}
