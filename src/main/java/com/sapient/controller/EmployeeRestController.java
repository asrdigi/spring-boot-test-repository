package com.sapient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.model.Employee;
import com.sapient.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    //http://localhost:9090/api/employees
    /*
     * post json object from postman
     * ex.
     * {
    	"name": "Rohit Sharma",
    	"hiredate": "2010-10-15",
    	"salary": 1350000.0
		}
     */
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee saved = employeeService.save(employee);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //http://localhost:9090/api/employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    
    //http://localhost:9090/api/employees/greater/1000000
    @GetMapping("/employees/greater/{salary}")
    public List<Employee> getAllSalaryGreaterThan(@PathVariable Double salary){
    	return employeeService.getAllSalaryGreaterThan(salary);
    }
    
    //http://localhost:9090/api/employees/1
//    @GetMapping("/employees/{id}")
//    public Employee getEmployeeById(@PathVariable("id") Long id){
//    	return employeeService.getEmployeeById(id);
//    }

}
