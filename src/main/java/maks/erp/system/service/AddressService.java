package maks.erp.system.service;

import maks.erp.system.dto.AddressDto;
import maks.erp.system.model.user.Address;
import maks.erp.system.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public void save(AddressDto addressDto) {
        Address newAddress = Address.builder()
                .road(addressDto.getRoad())
                .thana(addressDto.getThana())
                .city(addressDto.getCity())
                .district(addressDto.getDistrict())
                .postalCode(addressDto.getPostalCode())
                .build();
        addressRepository.save(newAddress);
    }
}
