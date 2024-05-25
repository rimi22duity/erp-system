package maks.erp.system.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import maks.erp.system.model.user.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesignationDto {

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    private String jobDescription;

    private String salaryRange;
}
