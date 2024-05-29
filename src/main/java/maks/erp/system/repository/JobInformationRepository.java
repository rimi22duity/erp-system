package maks.erp.system.repository;

import maks.erp.system.model.JobInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInformationRepository extends JpaRepository<JobInformation, Long> {
}
