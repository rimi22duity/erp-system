package maks.erp.system.service;

import maks.erp.system.dto.JobInformationDto;
import maks.erp.system.model.JobInformation;
import maks.erp.system.model.user.User;
import maks.erp.system.repository.JobInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobInformationService {
    @Autowired
    private JobInformationRepository jobInformationRepository;

    @Autowired
    private UserService userService;

    public void save(JobInformation jobInformation) {
        jobInformationRepository.save(jobInformation);
    }

    public void saveUserCompanyProfile(JobInformationDto jobInformationDto, long selectedUserId) {
        User user = userService.findUserById(selectedUserId);
        JobInformation jobInformation = JobInformation.builder()
                .basic(jobInformationDto.getBasic())
                .designation(jobInformationDto.getDesignation())
                .conveyanceAllowance(jobInformationDto.getConveyanceAllowance())
                .medicalReimbursement(jobInformationDto.getMedicalReimbursement())
                .houseRent(jobInformationDto.getHouseRent())
                .build();

        save(jobInformation);
        user.setJobInformation(jobInformation);
    }
}
