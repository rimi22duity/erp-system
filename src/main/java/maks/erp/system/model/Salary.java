package maks.erp.system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import maks.erp.system.enums.Currency;

/**
 * @author duity
 * @since 5/4/24
 */

@Entity
@Table
@Getter
@Setter
public class Salary {

    @Id
    @SequenceGenerator(name = "salarySeq", sequenceName = "salarySeq", allocationSize = 1)
    @GeneratedValue(generator = "salarySeq")
    private long id;

    private Currency currency;

    private double basic;
    private double conveyanceAllowance;
    private double medicalReimbursement;
    private double houseRent;
}