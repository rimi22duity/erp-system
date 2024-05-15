package maks.erp.system.service;

import maks.erp.system.model.user.Designation;
import maks.erp.system.repository.DesignationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void save(Designation designation) {
        designationRepository.save(designation);
    }

    public List<Designation> getDesignations() {
        return designationRepository.findAll();
    }

    public void editDesignation(Long id, Designation designation) {
        Designation prevDesignation = getDesignationById(id);

        prevDesignation.setTitle(designation.getTitle());
        prevDesignation.setJobDescription(designation.getJobDescription());
        prevDesignation.setSalaryRange(designation.getSalaryRange());

        save(prevDesignation);
    }

    public Designation getDesignationByTitle(String title) {
        return designationRepository.findDesignationByTitle(title);
    }
}
