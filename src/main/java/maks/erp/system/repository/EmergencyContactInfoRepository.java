package maks.erp.system.repository;

import maks.erp.system.model.user.EmergencyContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactInfoRepository extends JpaRepository<EmergencyContactInfo, Long> {
}
