package maks.erp.system.service;

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

@Service
public class DesignationService {

    Logger logger = LoggerFactory.getLogger(DesignationService.class);

    @Autowired
    DesignationRepository designationRepository;
    public Designation getDesignationById(long id) {
        Optional<Designation> optional = designationRepository.findById(id);

        Designation designation = null;
        if(optional.isPresent()){
            designation = optional.get();
        } else {
            logger.error(" Designation not found for the id" + id);
        }

        return designation;
    }
    public void save(DesignationDto designationDto) {
        Designation designation = Designation.builder()
                        .title(designationDto.getTitle())
                        .jobDescription((designationDto.getJobDescription()))
                .salaryRange(designationDto.getSalaryRange())
                .build();
        designationRepository.save(designation);
    }

    public List<DesignationDto> getDesignations() {
        List<Designation> designations = designationRepository.findAll();
        List<DesignationDto> designationDtos = new ArrayList<>();
        designations.forEach(designation -> {
            designationDtos.add(mapToDesignationDto(designation));
        });

        return designationDtos;
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
                .id(designation.getId())
                .title(designation.getTitle())
                .jobDescription(designation.getJobDescription())
                .salaryRange(designation.getSalaryRange())
                .users(designation.getUsers())
                .build();
    }
}
