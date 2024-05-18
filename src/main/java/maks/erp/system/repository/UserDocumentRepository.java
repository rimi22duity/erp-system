package maks.erp.system.repository;

import maks.erp.system.model.user.UserDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDocumentRepository extends JpaRepository<UserDocument, Long> {
}
