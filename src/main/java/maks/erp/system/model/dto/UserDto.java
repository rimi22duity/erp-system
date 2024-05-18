package maks.erp.system.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import maks.erp.system.enums.Gender;
import maks.erp.system.enums.Religion;
import maks.erp.system.model.user.ContactInfo;
import maks.erp.system.model.user.Designation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author duity
 * @since 5/4/24
 */

@Getter
@Setter
public class UserDto {

    @NotBlank
    private String username;
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
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

//    private Religion religion;
//
//    private Designation designation;
//
//    private ContactInfo contactInfo;
//
//    private Address presentAddress;
//
//    private Address permanentAddress;
//
//    private EmergencyContactInfo emergencyContact;
//
//    private UserDocument userDocument;
}