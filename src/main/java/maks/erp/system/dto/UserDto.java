package maks.erp.system.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Religion;
import maks.erp.system.model.user.ContactInfo;
import maks.erp.system.model.user.EmergencyContactInfo;
import maks.erp.system.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author duity
 * @since 5/4/24
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty(message = "This field should not be empty!")
    private String username;

    private String password;

    @NotEmpty(message = "This field should not be empty!")
    private String firstName;

    @NotEmpty(message = "This field should not be empty!")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private MultipartFile document;

    @Enumerated(EnumType.STRING)
    private Religion religion;

    private ContactInfo contactInfo;

    private EmergencyContactInfo emergencyContact;

    private AddressDto presentAddress;

    private AddressDto permanentAddress;

//    private List<LeaveInfoDto> leaveInfo;

}