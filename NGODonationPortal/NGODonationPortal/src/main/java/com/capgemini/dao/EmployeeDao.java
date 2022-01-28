package com.capgemini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Employee;
import com.capgemini.model.NeedyPeople;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>  {

//public int login(Employee employee);

@Query("select e from Employee e where e.username = ?1 and e.password = ?2")
public Employee findEmployeeByUsernameAndPassword(String username,String password);

//public int createNeedyPerson(NeedyPeople person);
//public int deleteNeedyPerson(NeedyPeople person);
@Query("select e from NeedyPeople e where e.needyPersonId = ?1")
public NeedyPeople readNeedyPeopleById(int id);

@Query("SELECT e FROM NeedyPeople e WHERE e.needyPersonName = ?1")
public List<NeedyPeople> readNeedyPeopleByName(String name);

@Query("SELECT e FROM NeedyPeople e")
public List<NeedyPeople> readAllNeedyPeople();
//public String helpNeedyPerson(DonationDistribution distribute);

}

