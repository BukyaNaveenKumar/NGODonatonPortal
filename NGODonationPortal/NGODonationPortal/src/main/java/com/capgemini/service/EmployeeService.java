package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.DonationDistribution;
import com.capgemini.model.NeedyPeople;

public interface EmployeeService {

public boolean login(String username,String password) throws NoSuchEmployeeException;
public boolean addNeedyPerson(NeedyPeople person);
public boolean removeNeedyPerson(int needyPersonId);
public NeedyPeople findNeedyPeopleById(int id);
public List<NeedyPeople> findNeedyPeopleByName(String name);
public List<NeedyPeople> findAllNeedyPeople();
public String helpNeedyPerson(DonationDistribution distribute);
}
