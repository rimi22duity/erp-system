package maks.erp.system.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import maks.erp.system.enums.Currency;
import maks.erp.system.enums.Gender;
import maks.erp.system.model.user.Designation;
import maks.erp.system.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobInformationDto {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joiningDate;

    @Min(200)
    private double basic;

    @NotNull
    private Currency currency;

    private double conveyanceAllowance;
    private double medicalReimbursement;
    private double houseRent;

    @NotNull
    private long designationId;

    private User user;

    public String getFormattedJoiningDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(this.joiningDate);
        return dateFormat.format(this.joiningDate);
    }
}
