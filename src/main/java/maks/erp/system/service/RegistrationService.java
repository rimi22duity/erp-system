package maks.erp.system.service;

import maks.erp.system.dto.UserDto;
import maks.erp.system.model.Salary;
import maks.erp.system.model.user.*;
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

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private EmergencyContactInfoService emergencyContactInfoService;

    @Autowired
    private ContactInfoService contactInfoService;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveUser(UserDto userDto) throws IOException {
        UserDocument userDocument = new UserDocument();
        userDocument.setDocument(userDto.getDocument().getBytes());
        userDocument.setFileName(userDto.getDocument().getOriginalFilename());

        EmergencyContactInfo emergencyContactInfo = emergencyContactInfoService.save(userDto.getEmergencyContact());
        Address permanentAddress = addressService.save(addressService.mapToAddress(userDto.getPermanentAddress()));
        Address presentAddress = addressService.save(addressService.mapToAddress(userDto.getPresentAddress()));
        UserDocument userDocument1 = userDocumentService.save(userDocument);
        ContactInfo contactInfo = contactInfoService.save(userDto.getContactInfo());

        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .birthDate(userDto.getBirthDate())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .userDocument(userDocument1)
                .gender(userDto.getGender())
                .religion(userDto.getReligion())
                .emergencyContact(emergencyContactInfo)
                .permanentAddress(permanentAddress)
                .presentAddress(presentAddress)
                .contactInfo(contactInfo)
                .build();

        saveUser(user);
    }

    public Optional<User> getUserByUserName(String userName) {
        return userRepository.getUserByUsername(userName);
    }
}
