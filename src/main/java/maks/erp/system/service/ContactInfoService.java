package maks.erp.system.service;

import maks.erp.system.model.user.ContactInfo;
import maks.erp.system.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoService {

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    public ContactInfo save(ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }
}
