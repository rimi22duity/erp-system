package maks.erp.system.repository;

import maks.erp.system.model.user.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author duity
 * @since 5/4/24
 */

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {
}
