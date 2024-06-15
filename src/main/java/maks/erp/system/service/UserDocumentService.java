package maks.erp.system.service;

import maks.erp.system.model.user.UserDocument;
import maks.erp.system.repository.UserDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDocumentService {
    @Autowired
    private UserDocumentRepository userDocumentRepository;

    public UserDocument save(UserDocument userDocument) {
        return userDocumentRepository.save(userDocument);
    }
}
