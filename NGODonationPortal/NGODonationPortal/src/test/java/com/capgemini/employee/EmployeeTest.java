package com.capgemini.employee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.EmployeeService;


@SpringBootTest
class EmployeeTest {

@MockBean
EmployeeDao employeeDao;


	
@MockBean
NeedyPeopleDao needyPeopleDao;


@Autowired
EmployeeService employeeService;


@Test
void testAddNeedyPerson() {
NeedyPeople person = new NeedyPeople();
person.setNeedyPersonId(5);
person.setNeedyPersonName("william");
person.setFamilyIncome(324232);
person.setPhone("42435545");
Mockito.when(needyPeopleDao.save(person)).thenReturn(person);
boolean bool = employeeService.addNeedyPerson(person);
assertEquals(true,bool);
}



@Test
void testRemoveNeedyPerson() {
NeedyPeople person = new NeedyPeople();
person.setNeedyPersonId(5);
person.setNeedyPersonName("william");
person.setFamilyIncome(324232);
person.setPhone("42435545");
employeeService.removeNeedyPerson(5);
Mockito.verify(needyPeopleDao, times(1)).deleteById(person.getNeedyPersonId());
// assertEquals(needyPerson, "Deleted Successfully");
}




@Test
void testLogin() throws NoSuchEmployeeException {
Employee employee = new Employee();
employee.setEmployeeId(5);
employee.setEmployeeName("peter");
employee.setEmail("peter12@gmail.com");
employee.setPhone("3242435364");
employee.setUsername("peter12");
employee.setPassword("peter@12");
Mockito.when(employeeDao.findEmployeeByUsernameAndPassword("peter12", "peter@12")).thenReturn(employee);
boolean bool = employeeService.login("peter12", "peter@12");
assertEquals(true, bool);
}
}