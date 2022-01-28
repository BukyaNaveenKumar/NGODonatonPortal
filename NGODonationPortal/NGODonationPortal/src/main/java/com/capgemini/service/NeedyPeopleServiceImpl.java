package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.model.NeedyPeople;

@Service
public class NeedyPeopleServiceImpl implements NeedyPeopleService {

@Autowired
NeedyPeopleDao needyPeopleDao;

@Override
public boolean registerNeedyPerson(NeedyPeople person) {
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
public boolean requestForHelp(NeedyPeople person) {
// TODO Auto-generated method stub

return false;
}

}