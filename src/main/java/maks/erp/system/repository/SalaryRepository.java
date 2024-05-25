package maks.erp.system.repository;

import maks.erp.system.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
