package maks.erp.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.LeaveType;
import maks.erp.system.model.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
public class LeaveInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "leaveInfoSeq",
            sequenceName = "leaveInfoSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "leaveInfoSeq")
    private long id;

    @NotNull(message = "Please select a type")
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private String description;

    @NotNull(message = "From field cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @NotNull(message = "To field cannot be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Version
    private int version = 0;

    public long getNumberOfDays() {
        return TimeUnit.MILLISECONDS.toDays(this.toDate.getTime() - this.fromDate.getTime()) % 365;
    }

    public String getDateRangeString() {
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-YYYY");
        String toDateString = sm.format(this.toDate);
        String fromDateString = sm.format(this.fromDate);

        return fromDateString + " - " + toDateString;
    }

    public String getRequestedDate() {
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-YYYY");
        String requestedDate = sm.format(this.created);

        return requestedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeaveInfo)) return false;
        LeaveInfo leaveInfo = (LeaveInfo) o;
        return id == leaveInfo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
