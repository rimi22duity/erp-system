package maks.erp.system.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.model.user.Designation;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Currency currency;

    private double conveyanceAllowance;
    private double medicalReimbursement;
    private double houseRent;

    @NotBlank
    @OneToOne
    private Designation designation;
}
