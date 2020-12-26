package com.sapient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sapient.model.Employee;

@Repository
//@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
	public Employee findByName(String name);
    
    @Query("select e from Employee e where e.salary > :psal")
    public List<Employee> getAllSalaryGreaterThan(@Param("psal") Double salary);

}
