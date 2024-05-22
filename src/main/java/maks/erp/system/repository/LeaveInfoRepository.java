package maks.erp.system.repository;

import maks.erp.system.model.LeaveInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveInfoRepository extends JpaRepository<LeaveInfo, Long> {
}
