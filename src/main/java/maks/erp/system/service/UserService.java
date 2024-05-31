package maks.erp.system.service;

import maks.erp.system.dto.JobInformationDto;
import maks.erp.system.dto.UserDto;
import maks.erp.system.model.JobInformation;
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

    @Autowired
    private JobInformationService jobInformationService;

    public UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public List<User> getUserList() {
       return userRepository.findAll();
    }

    public User findUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    public void saveUserCompanyProfile(JobInformationDto jobInformationDto, long selectedUserId) {
        User user = findUserById(selectedUserId);
        JobInformation jobInformation = JobInformation.builder()
                .basic(jobInformationDto.getBasic())
                .designation(jobInformationDto.getDesignation())
                .conveyanceAllowance(jobInformationDto.getConveyanceAllowance())
                .medicalReimbursement(jobInformationDto.getMedicalReimbursement())
                .houseRent(jobInformationDto.getHouseRent())
                .build();

        jobInformationService.save(jobInformation);
        user.setJobInformation(jobInformation);

    }
}
