package maks.erp.system.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import maks.erp.system.model.JobInformation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Designation {

    @Id
    @SequenceGenerator(name = "designationSeq", sequenceName = "designationSeq", allocationSize = 1)
    @GeneratedValue(generator = "designationSeq")
    private long id;

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String jobDescription;

    private String salaryRange;

    @OneToMany
    private List<User> users;

    @OneToMany(mappedBy = "designation")
    private Set<JobInformation> jobInformations;

    public Designation() {
        jobInformations  = new HashSet<>();
    }
}
