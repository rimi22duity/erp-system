package maks.erp.system.model;

import jakarta.persistence.*;
import maks.erp.system.model.user.User;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
public class Task {

    @Id
    @SequenceGenerator(name = "taskSeq", sequenceName = "taskSeq", allocationSize = 1)
    @GeneratedValue(generator = "taskSeq")
    private long id;

    private String title;
    private String description;

    @OneToMany
    private ArrayList<User> assigneeList;

    @OneToOne
    private User reportedBy;

    private Date created;
    private Date updated;
    private Date eta;
    private Date completedOn;

    private Currency taskAllowanceCurrency;
    private double taskAllowance;
}
