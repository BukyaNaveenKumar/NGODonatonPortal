package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AdminDao;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.DonationDistributionStatus;
import com.capgemini.model.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

@Autowired
AdminDao adminDao;

@Override
public boolean addEmployee(Employee employee) throws DuplicateEmployeeException{
Employee savedEmployee = null;
savedEmployee =  adminDao.save(employee);
if(savedEmployee == null) {
return false;
}
else {
return true;
}

}

@Override
public Employee modifyEmployee(Employee employee) throws NoSuchEmployeeException{
return adminDao.save(employee);
}

@Override
public boolean removeEmployee(int employeeId) throws NoSuchEmployeeException{
adminDao.deleteById(employeeId);
Optional<Employee> deleteEmployee = adminDao.findById(employeeId);
return deleteEmployee.isPresent();
}

@Override
public Optional<Employee> findEmployeeById(int employeeId) throws NoSuchEmployeeException{
return adminDao.findById(employeeId);
}

@Override
public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException{
return adminDao.readEmployeeByName(name);
}

@Override
public List<Employee> findAllEmployee() throws NoSuchEmployeeException{
return adminDao.findAll();
}

@Override
public boolean approveDonation(DonationDistribution distribution) {
DonationDistributionStatus d = DonationDistributionStatus.APPROVED;
if(distribution.getStatus() == d) {
return true;
}
else {
return false;
}
}

}
