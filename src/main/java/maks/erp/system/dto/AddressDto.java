package maks.erp.system.dto;

import jakarta.persistence.*;
import lombok.*;
import maks.erp.system.model.user.User;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    private String road;
    private String thana;
    private String city;
    private String district;
    private String postalCode;

    private User user;

}