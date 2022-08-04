package com.springboot.tutorial.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Entity
@Table(name="employee")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "joining_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;
	
	@Column(name = "retiring_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate retiringDate;
	
	@Column(name="dept")
	private String dept;
	
	@Column(name="address")
	private String address;
	
	@Column(name="salary")
     private String salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalDate getRetiringDate() {
		return retiringDate;
	}

	public void setRetiringDate(LocalDate retiringDate) {
		this.retiringDate = retiringDate;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", joiningDate="
				+ joiningDate + ", retiringDate=" + retiringDate + ", dept=" + dept + ", address=" + address
				+ ", salary=" + salary + "]";
	}

	
}
