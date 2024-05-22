package maks.erp.system.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import maks.erp.system.enums.LeaveType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class LeaveInfoDto {

    @NotBlank(message = "Please select a type")
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private String description;

    @NotBlank(message = "From date should not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @NotBlank(message = "To date should not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toDate;
}
