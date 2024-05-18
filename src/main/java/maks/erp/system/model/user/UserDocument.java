package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author duity
 * @since 5/7/24
 */

@Entity
@Table
@Getter
@Setter
public class UserDocument {

    @Id
    @SequenceGenerator(name = "userDocSeq",
            sequenceName = "userDocSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "userDocSeq")
    private long id;

    private String fileName;

    @Lob
    @Column(length = 100000)
    private byte[] document;
}