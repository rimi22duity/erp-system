package maks.erp.system.repository;

import maks.erp.system.model.user.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
