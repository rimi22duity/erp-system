package maks.erp.system.model.user;

import jakarta.persistence.*;
import lombok.*;
import maks.erp.system.model.Salary;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserJobDetails {

    @Id
    @SequenceGenerator(name = "jobDetailsSeq", sequenceName = "jobDetailsSeq", allocationSize = 1)
    @GeneratedValue(generator = "jobDetailsSeq")
    private long id;

    @OneToOne
    private Salary salary;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;
}
