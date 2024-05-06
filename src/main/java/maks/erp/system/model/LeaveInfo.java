package maks.erp.system.model;

import jakarta.persistence.*;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
public class LeaveInfo {

    @Id
    @SequenceGenerator(name = "leaveInfoSeq", sequenceName = "leaveInfoSeq", allocationSize = 1)
    @GeneratedValue(generator = "leaveInfoSeq")
    private long id;
}
