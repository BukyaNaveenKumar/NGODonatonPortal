package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.model.Donor;

import com.capgemini.service.DonorServiceImpl;

@RestController
@RequestMapping("/donor")
public class DonorController {

@Autowired
DonorServiceImpl donorService;

@PostMapping("/registerDonor")
public String registerDonor(@RequestBody Donor donor) throws DuplicateDonorException{
if(donorService.registerDonor(donor)) {
return "Donor Registered Successfully";
}
else {
return "Donor not Registered";
}
}

@GetMapping("/login/{username}/{password}")
public String login(@PathVariable String username, @PathVariable String password) throws NoSuchDonorException {

if(donorService.login(username,password)) {
return "Login Successfull";
}
else {
return "Login failed";
}
}

@GetMapping("/forgotPassword/{donorUsername}")
public String forgotPassword(@PathVariable String donorUsername) {
return donorService.forgotPassword(donorUsername);
}

@PutMapping("/resetPassword/{donorUsername}/{donorNewPassword}")
public String resetPassword(@PathVariable String donorUsername,@PathVariable String donorNewPassword) {

return donorService.resetPassword(donorUsername,donorNewPassword);
}

@GetMapping("/getDonor/{donorId}")
public Optional<Donor> getDonor(@PathVariable int donorId){

return donorService.findDonorById(donorId);
}

@GetMapping("/getAllDonors")
public List<Donor> getAllDonors(){
return donorService.findAllDonors();
}

}