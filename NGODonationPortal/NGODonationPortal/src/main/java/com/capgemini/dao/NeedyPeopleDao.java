package com.capgemini.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.model.NeedyPeople;

@Repository
public interface NeedyPeopleDao extends JpaRepository<NeedyPeople,Integer> {

// public int login(NeedyPeople person);
// public int createNeedyPerson(NeedyPeople person);
// public int deleteNeedyPerson(NeedyPeople person);
// public NeedyPeople readNeedyPeopleById(int id);
// public List<NeedyPeople> readNeedyPeopleByName(String name);
// public List<NeedyPeople> readAllNeedyPeople();
// public String helpNeedyPerson(DonationDistribution distribute);

}