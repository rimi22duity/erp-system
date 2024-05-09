package maks.erp.system.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
public class Designation {

    @Id
    @SequenceGenerator(name = "designationSeq", sequenceName = "designationSeq", allocationSize = 1)
    @GeneratedValue(generator = "designationSeq")
    private long id;

    @NotBlank
    @Size(max = 8)
    private String title;

    @NotBlank
    private String jobDescription;
    private String salaryRange;

    @OneToMany
    private List<User> users;
}
