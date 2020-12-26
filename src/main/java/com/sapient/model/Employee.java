package com.sapient.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;



@Entity
@Table(name = "employee_sapient")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 20)
    private String name;
    @Temporal(TemporalType.DATE) 
    private Date hiredate;
    private Double salary;
    
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }      

    public Employee( @Size(min = 3, max = 20) String name, Date hiredate, Double salary) {
		super();		
		this.name = name;
		this.hiredate = hiredate;
		this.salary=salary;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	    
}