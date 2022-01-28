package com.capgemini.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

@Autowired
EmployeeServiceImpl empService;
@GetMapping("/login/{username}/{password}")
public String login(@PathVariable String username, @PathVariable String password) throws NoSuchDonorException, NoSuchEmployeeException {

if(empService.login(username,password)) {
return "Login Successfull";
}
else {
return "Login failed";
}
}

@PostMapping("/addNeedyPerson")
public String addNeedyPerson(@RequestBody NeedyPeople person) throws DuplicateDonorException{
if(empService.addNeedyPerson(person)) {
return "Registered Successfully";
}
else {
return "not Registered";
}
}

@DeleteMapping("/deleteNeedyPerson/{personId}")
public String removeNeedyPerson(@PathVariable int personId) throws NoSuchEmployeeException{
if(empService.removeNeedyPerson(personId)) {
return "Deletion operation is not performed";
}
else {

return "Deleted Successfully";
}
}

@GetMapping("/getNeedyPerson/{personId}")
public NeedyPeople getNeedyPerson(@PathVariable int personId){
return empService.findNeedyPeopleById(personId);
}

@GetMapping("/getNeedyPerson")
public List<NeedyPeople> getNeedyPerson(){
return empService.findAllNeedyPeople();
}

@GetMapping("/getNeedyPersonByName/{personName}")
public List<NeedyPeople> getNeedyPerson(@PathVariable String personName){
return empService.findNeedyPeopleByName(personName);
}

}
