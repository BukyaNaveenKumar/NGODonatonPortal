package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.NeedyPeopleServiceImpl;

@RestController
@RequestMapping("/needyPeople")
public class NeedyPeopleController {
	
@Autowired
NeedyPeopleServiceImpl needyPeopleService;
@PostMapping("/registerNeedyPeople")
public String registerNeedyPeople(@RequestBody NeedyPeople person) throws DuplicateDonorException{
if(needyPeopleService.registerNeedyPerson(person)) {
return "Registered Successfully";
}
else {
return "not Registered";
}
}


}
