package maks.erp.system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
public class ActivityLog {

    @Id
    @SequenceGenerator(name = "activityLogSeq", sequenceName = "activityLogSeq", allocationSize = 1)
    @GeneratedValue(generator = "activityLogSeq")
    private long id;

    private Date created;

    private String action;
    private String description;
    private String pageName;
}