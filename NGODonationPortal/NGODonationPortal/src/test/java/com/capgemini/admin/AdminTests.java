package com.capgemini.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.capgemini.model.Employee;
import com.capgemini.service.AdminService;
import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.capgemini.dao.AdminDao;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.NoSuchEmployeeException;



@SpringBootTest
class AdminModuleTests {


@Autowired
AdminService adminService;


@MockBean
AdminDao adminDao;

@Test
void testAddEmployee() throws DuplicateEmployeeException {
Employee employee = new Employee();
employee.setEmployeeId(5);
employee.setEmployeeName("peter");
employee.setEmail("peter12@gmail.com");
employee.setPhone("3242435364");
employee.setUsername("peter12");
employee.setPassword("peter@12");
Mockito.when(adminDao.save(employee)).thenReturn(employee);
boolean bool = adminService.addEmployee(employee);
assertEquals(true,bool);
}

@Test
void testgetEmployee() throws NoSuchEmployeeException {
	
	Employee employee = new Employee();
	employee.setEmployeeId(5);
	employee.setEmployeeName("peter");
	employee.setEmail("peter12@gmail.com");
	employee.setPhone("3242435364");
	employee.setUsername("peter12");
	employee.setPassword("peter@12");
	Optional<Employee> employee1 = Optional
			.of(employee);
	Mockito.when(adminDao.findById(5)).thenReturn((employee1));
	Optional<Employee> emp = adminService.findEmployeeById(5);
	assertEquals(emp, employee1);// assertEquals()
}

@Test
void testGetAllEmployees() throws NoSuchEmployeeException {
List<Employee> employeeList = new ArrayList<Employee>();

Employee employee1 = new Employee();
employee1.setEmployeeId(5);
employee1.setEmployeeName("peter");
employee1.setEmail("peter12@gmail.com");
employee1.setPhone("3242435364");
employee1.setUsername("peter12");
employee1.setPassword("peter@12");

Employee employee2 = new Employee();
employee2.setEmployeeId(6);
employee2.setEmployeeName("Joey");
employee2.setEmail("joey12@gmail.com");
employee2.setPhone("43535535321");
employee2.setUsername("joey12");
employee2.setPassword("joey@12");

Employee employee3 = new Employee();
employee3.setEmployeeId(7);
employee3.setEmployeeName("smith");
employee3.setEmail("smith12@gmail.com");
employee3.setPhone("9798724009");
employee3.setUsername("smith12");
employee3.setPassword("smith@12");
Mockito.when(adminDao.findAll()).thenReturn((Arrays.asList(employee1, employee2,employee3)));
employeeList = adminService.findAllEmployee();
assertEquals(3, employeeList.size());
}

@Test
void testUpdateEmployee() throws NoSuchEmployeeException {
Employee employee = new Employee();
employee.setEmployeeId(5);
employee.setEmployeeName("peter");
employee.setEmail("peter1234@gmail.com");
employee.setPhone("3242435364");
employee.setUsername("peter12");
employee.setPassword("peter@12");
Mockito.when(adminDao.save(employee)).thenReturn(employee);
Employee emp = adminService.modifyEmployee(employee);
assertEquals("peter1234@gmail.com", emp.getEmail());
}


@Test
void testRemoveEmployee() throws NoSuchEmployeeException {
	Employee employee = new Employee();
	employee.setEmployeeId(5);
	employee.setEmployeeName("peter");
	employee.setEmail("peter12@gmail.com");
	employee.setPhone("3242435364");
	employee.setUsername("peter12");
	employee.setPassword("peter@12");
	
	adminService.removeEmployee(employee.getEmployeeId());
	Mockito.verify(adminDao, times(1)).deleteById(5);
}

}