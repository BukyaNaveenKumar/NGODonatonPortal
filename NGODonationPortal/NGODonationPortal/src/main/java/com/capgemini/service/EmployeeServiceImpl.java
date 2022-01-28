package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;

@Service
public class EmployeeServiceImpl implements EmployeeService {

@Autowired
EmployeeDao empDao;

@Autowired
NeedyPeopleDao needyPeopleDao;

@Override
public boolean login(String username, String password) throws NoSuchEmployeeException {
// TODO Auto-generated method stub
Employee e1 = empDao.findEmployeeByUsernameAndPassword(username,password);
if(e1 == null) {
return false;
}
else {
return true;
}

}

@Override
public boolean addNeedyPerson(NeedyPeople person) {
// TODO Auto-generated method stub
NeedyPeople needyPeople = needyPeopleDao.save(person);
if(needyPeople == null){
return false;
}
else {
return true;
}
}

@Override
public boolean removeNeedyPerson(int needyPersonId) {
needyPeopleDao.deleteById(needyPersonId);
Optional<NeedyPeople> deleteEmployee = needyPeopleDao.findById(needyPersonId);
return deleteEmployee.isPresent(); }

@Override
public NeedyPeople findNeedyPeopleById(int id) {
// TODO Auto-generated method stub
return empDao.readNeedyPeopleById(id);
}

@Override
public List<NeedyPeople> findNeedyPeopleByName(String name) {
// TODO Auto-generated method stub

return empDao.readNeedyPeopleByName(name);
}



@Override
public List<NeedyPeople> findAllNeedyPeople() {
// TODO Auto-generated method stub

return empDao.readAllNeedyPeople();
}

@Override
public String helpNeedyPerson(DonationDistribution distribute) {
// TODO Auto-generated method stub
//return empDao.helpNeedyPerson(distribute);
return "String";
}

}
