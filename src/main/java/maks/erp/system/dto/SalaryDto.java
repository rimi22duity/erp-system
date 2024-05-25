package maks.erp.system.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import maks.erp.system.enums.Currency;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {

    @NotBlank
    private Currency currency;

    @NotBlank
    private double basic;
    private double conveyanceAllowance;
    private double medicalReimbursement;
    private double houseRent;
}
