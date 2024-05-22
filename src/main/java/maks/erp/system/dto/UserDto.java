package maks.erp.system.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Religion;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joiningDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private double salary;

    @NotNull
    private MultipartFile document;

    @Enumerated(EnumType.STRING)
    private Religion religion;

    @NotNull
    private DesignationDto designationDto;
//
//    private ContactInfo contactInfo;
//
    private AddressDto presentAddress;

    private AddressDto permanentAddress;
//
//    private EmergencyContactInfo emergencyContact;
//
//    private UserDocument userDocument;
//    private List<LeaveInfoDto> leaveInfo;
}