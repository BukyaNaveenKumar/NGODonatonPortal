package com.capgemini.needy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.NeedyPeopleService;

@SpringBootTest
public class TestNeedyPeople {

	@MockBean
	NeedyPeopleDao needyPeopleDao;

	@Autowired
	NeedyPeopleService service;
	@Test
	void testAddNeedyPerson() {

	NeedyPeople person = new NeedyPeople();
	person.setNeedyPersonId(7);
	person.setNeedyPersonName("shyam");
	person.setFamilyIncome(324232);
	person.setPhone("42435544");
	Mockito.when(needyPeopleDao.save(person)).thenReturn(person);
	boolean bool = service.registerNeedyPerson(person);
	assertEquals(true,bool);
	}
}
