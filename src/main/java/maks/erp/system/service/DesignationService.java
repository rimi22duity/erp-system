package maks.erp.system.service;

import maks.erp.system.model.user.Designation;
import maks.erp.system.repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationService {

    @Autowired
    DesignationRepository designationRepository;

    public void save(Designation designation) {
        designationRepository.save(designation);
    }

    public List<Designation> getDesignations() {
        return designationRepository.findAll();
    }

    public Designation getDesignationByTitle(String title) {
        return designationRepository.findDesignationByTitle(title);
    }
}
