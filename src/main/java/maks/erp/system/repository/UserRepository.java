package maks.erp.system.repository;

import maks.erp.system.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author duity
 * @since 5/4/24
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> getUserByUsername(String username);
}
