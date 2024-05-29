package maks.erp.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.model.user.Designation;
import maks.erp.system.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Table
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobInformation {

    @Id
    @SequenceGenerator(name = "jobInfoSeq",
            sequenceName = "jobInfoSeq",
            allocationSize = 1)
    @GeneratedValue(generator = "jobInfoSeq")
    private long id;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joiningDate;

    @NotBlank
    private double basic;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private double conveyanceAllowance;
    private double medicalReimbursement;
    private double houseRent;

    @NotBlank
    @OneToOne
    private Designation designation;

    @OneToOne
    private User user;

    @Transient
    private String joinningDateString;

    public String getJoiningDateString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(joinningDateString);
    }

    private String getFormattedAllowance(double amount) {
        return this.getCurrency().toString() + amount;
    }

    public String getBasicSalaryString() {
        return getFormattedAllowance(this.basic);
    }

    public String getConveyanceAllowanceString() {
        return getFormattedAllowance(this.conveyanceAllowance);
    }


    public String getMedicalReimbursementString() {
        return getFormattedAllowance(this.medicalReimbursement);
    }

    public String getHouseRentString() {
        return getFormattedAllowance(this.houseRent);
    }
}
