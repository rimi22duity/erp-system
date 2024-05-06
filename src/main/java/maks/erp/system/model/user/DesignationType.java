package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
public class DesignationType {

    @Id
    @SequenceGenerator(name = "designationTypeSeq", sequenceName = "designationTypeSeq", allocationSize = 1)
    @GeneratedValue(generator = "designationTypeSeq")
    private long id;
    private String title;
    private String jobDescription;
    private String salaryRange;
}
