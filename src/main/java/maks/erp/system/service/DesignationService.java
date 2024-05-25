package maks.erp.system.service;

import lombok.extern.slf4j.Slf4j;
import maks.erp.system.dto.DesignationDto;
import maks.erp.system.model.user.Designation;
import maks.erp.system.repository.DesignationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DesignationService {

    @Autowired
    DesignationRepository designationRepository;

    public Designation getDesignationById(long id) {
        return Optional.of(designationRepository.findById(id)).get().orElse(null);
    }

    public void save(DesignationDto designationDto) {
        Designation designation = Designation.builder()
                .title(designationDto.getTitle())
                .jobDescription((designationDto.getJobDescription()))
                .salaryRange(designationDto.getSalaryRange())
                .build();
        designationRepository.save(designation);
    }

    public List<Designation> getDesignations() {
        return designationRepository.findAll();
    }

    public void editDesignation(Long id, DesignationDto designationDto) {
        Designation prevDesignation = getDesignationById(id);

        prevDesignation.setTitle(designationDto.getTitle());
        prevDesignation.setJobDescription(designationDto.getJobDescription());
        prevDesignation.setSalaryRange(designationDto.getSalaryRange());

        designationRepository.save(prevDesignation);
    }

    public Designation getDesignationByTitle(String title) {
        return designationRepository.findDesignationByTitle(title);
    }

    public DesignationDto mapToDesignationDto(Designation designation) {
        return DesignationDto.builder()
                .title(designation.getTitle())
                .jobDescription(designation.getJobDescription())
                .salaryRange(designation.getSalaryRange())
                .build();
    }
}
