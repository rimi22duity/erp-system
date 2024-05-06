package maks.erp.system.repository;

import maks.erp.system.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author duity
 * @since 5/4/24
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
