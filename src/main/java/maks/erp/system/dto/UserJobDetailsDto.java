package maks.erp.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import maks.erp.system.enums.Currency;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserJobDetailsDto {

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joiningDate;

    private SalaryDto salaryDto;

    @NotBlank
    private DesignationDto designationDto;
}
