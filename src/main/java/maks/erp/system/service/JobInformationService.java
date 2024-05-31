package maks.erp.system.service;

import maks.erp.system.dto.JobInformationDto;
import maks.erp.system.dto.UserDto;
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

    @Autowired
    private DesignationService designationService;

    public JobInformation findById(long id) {
        return jobInformationRepository.findById(id).get();
    }

    public void save(JobInformation jobInformation) {
        jobInformationRepository.save(jobInformation);
    }

    public JobInformationDto mapToJobInformationDto(JobInformation jobInformation) {
        return JobInformationDto.builder()
                .joiningDate(jobInformation.getJoiningDate())
                .basic(jobInformation.getBasic())
                .designationId(jobInformation.getDesignation().getId())
                .currency(jobInformation.getCurrency())
                .conveyanceAllowance(jobInformation.getConveyanceAllowance())
                .medicalReimbursement(jobInformation.getMedicalReimbursement())
                .houseRent(jobInformation.getHouseRent())
                .build();
    }

    public void saveUserCompanyProfile(JobInformationDto jobInformationDto) {
        User user = userService.findUserById(jobInformationDto.getUser().getId());
        JobInformation jobInformation = JobInformation.builder()
                .basic(jobInformationDto.getBasic())
                .joiningDate(jobInformationDto.getJoiningDate())
                .currency(jobInformationDto.getCurrency())
                .designation(designationService.getDesignationById(jobInformationDto.getDesignationId()))
                .conveyanceAllowance(jobInformationDto.getConveyanceAllowance())
                .medicalReimbursement(jobInformationDto.getMedicalReimbursement())
                .houseRent(jobInformationDto.getHouseRent())
                .user(user)
                .build();

        save(jobInformation);
        user.setJobInformation(jobInformation);
        userService.save(user);
    }

    public void updateCompanyProfile(JobInformationDto jobInformationDto) {
        User user = userService.findUserById(jobInformationDto.getUser().getId());
        JobInformation jobInformation = updatedJobInformation(user.getJobInformation().getId(), jobInformationDto);

        save(jobInformation);
        user.setJobInformation(jobInformation);
        userService.save(user);
    }

    public JobInformation updatedJobInformation(long id, JobInformationDto jobInformationDto) {
        JobInformation jobInformation = findById(id);

        System.out.println("Joining Date: " + jobInformationDto.getJoiningDate());
        jobInformation.setJoiningDate(jobInformationDto.getJoiningDate());
        jobInformation.setDesignation(designationService.getDesignationById(jobInformationDto.getDesignationId()));
        jobInformation.setBasic(jobInformationDto.getBasic());
        jobInformation.setConveyanceAllowance(jobInformationDto.getConveyanceAllowance());
        jobInformation.setMedicalReimbursement(jobInformationDto.getMedicalReimbursement());
        jobInformation.setHouseRent(jobInformationDto.getHouseRent());

        return jobInformation;
    }
}
