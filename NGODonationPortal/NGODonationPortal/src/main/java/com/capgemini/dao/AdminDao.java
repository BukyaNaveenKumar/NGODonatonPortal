package com.capgemini.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.model.Employee;

@Repository
public interface AdminDao extends JpaRepository<Employee,Integer> {

//public int createEmployee(Employee employee);
//public Employee updateEmployee(Employee employee) throws SQLException;
//public int deleteEmployee(int employeeId) throws SQLException;
@Query("SELECT e FROM Employee e WHERE e.employeeId = ?1")
public Employee readEmployeeById(int employeeId) throws SQLException;

@Query("SELECT e FROM Employee e WHERE e.employeeName = ?1")
public List<Employee> readEmployeeByName(String name);

@Query("SELECT e FROM Employee e")
public List<Employee> readAllEmployees() throws SQLException;

//public boolean approveDonation(DonationDistribution distribution);
}