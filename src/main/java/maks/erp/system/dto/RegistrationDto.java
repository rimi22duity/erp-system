package maks.erp.system.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;


@Getter
@Setter
public class RegistrationDto {

    @NotBlank
    private String username;
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String birthDate;
    private String joiningDate;
    private String genderString;
    private String designationTitle;
    private String relationshipTitle;
    private String religionTitle;
}
