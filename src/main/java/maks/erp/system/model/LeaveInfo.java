package maks.erp.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.LeaveType;
import maks.erp.system.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LeaveInfo {

    @Id
    @SequenceGenerator(name = "leaveInfoSeq",
            sequenceName = "leaveInfoSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "leaveInfoSeq")
    private long id;

    @NotBlank(message = "Please select a type")
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private String description;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    @ManyToOne
    private User user;
}
