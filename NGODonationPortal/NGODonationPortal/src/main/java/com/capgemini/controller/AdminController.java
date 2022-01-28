package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Employee;
import com.capgemini.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
 
@Autowired
AdminServiceImpl adminService;

@PostMapping("/addEmployee")
public Optional<Employee> addEmployee(@RequestBody Employee employee) throws DuplicateEmployeeException, NoSuchEmployeeException{
 adminService.addEmployee(employee);
 return adminService.findEmployeeById(employee.getEmployeeId());
}

@PutMapping("/updateEmployee")
public Employee updateEmployee(@RequestBody Employee emp) throws NoSuchEmployeeException {
return adminService.modifyEmployee(emp);
}

@DeleteMapping("/deleteEmployee/{empId}")
public String removeEmployee(@PathVariable int empId) throws NoSuchEmployeeException{
if(adminService.removeEmployee(empId)) {
return "Deletion operation is not performed";
}
else {

return "Deleted Successfully";
}
}

@GetMapping("/getEmployee/{empId}")
public Optional<Employee> getEmployee(@PathVariable int empId) throws NoSuchEmployeeException{

return adminService.findEmployeeById(empId);

}

@GetMapping("/getAllEmployees")
public List<Employee> findEmployees() throws NoSuchEmployeeException {
return adminService.findAllEmployee();
}



}
