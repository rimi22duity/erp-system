package maks.erp.system.service;


import maks.erp.system.model.user.EmergencyContactInfo;
import maks.erp.system.repository.EmergencyContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyContactInfoService {

    @Autowired
    private EmergencyContactInfoRepository emergencyContactInfoRepository;

    public EmergencyContactInfo save(EmergencyContactInfo emergencyContactInfo) {
        return emergencyContactInfoRepository.save(emergencyContactInfo);
    }
}
