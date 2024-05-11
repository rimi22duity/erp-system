package maks.erp.system.service;

import maks.erp.system.model.user.User;
import maks.erp.system.model.user.UserDocuments;
import maks.erp.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) { userRepository.save(user); }

    public void saveNewUser(User user, MultipartFile file) throws IOException {
        UserDocuments userDocuments = new UserDocuments();
        userDocuments.setDocument(Base64.getEncoder().encodeToString(file.getBytes()));

        user.setUserDocuments(userDocuments);

        saveUser(user);
    }
}
