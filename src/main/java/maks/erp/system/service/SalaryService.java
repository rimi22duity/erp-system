package maks.erp.system.service;

import maks.erp.system.dto.SalaryDto;
import maks.erp.system.model.Salary;
import maks.erp.system.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;
    public void save(SalaryDto salaryDto) {
        salaryRepository.save(Salary.builder()
                .basic(salaryDto.getBasic())
                .conveyanceAllowance(salaryDto.getConveyanceAllowance())
                .houseRent(salaryDto.getHouseRent())
                .medicalReimbursement(salaryDto.getMedicalReimbursement())
                .currency(salaryDto.getCurrency())
                .build());
    }
}
