package maks.erp.system.service;

import maks.erp.system.model.JobInformation;
import maks.erp.system.repository.JobInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobInformationService {
    @Autowired
    private JobInformationRepository jobInformationRepository;

    public void save(JobInformation jobInformation) {
        jobInformationRepository.save(jobInformation);
    }
}
