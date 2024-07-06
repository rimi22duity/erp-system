package maks.erp.system.repository;

import maks.erp.system.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author duity
 * @since 6/29/24
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT r.* FROM role r " +
            " JOIN role_user ru ON ru.role_id = r.id " +
            " JOIN user u ON u.id = ru.user_id " +
            " WHERE u.username =?1",
            nativeQuery = true)
    Set<Role> findRolesByUsers(String username);
}
