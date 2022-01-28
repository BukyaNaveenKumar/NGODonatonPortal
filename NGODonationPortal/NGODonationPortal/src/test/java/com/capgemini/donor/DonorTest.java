package com.capgemini.donor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.capgemini.model.Donor;
import com.capgemini.service.DonorService;
import com.capgemini.dao.DonationDao;
import com.capgemini.dao.DonorDao;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.NoSuchDonorException;





@SpringBootTest
class DonorTest {
@MockBean
DonorDao donorDao;

@MockBean
DonationDao donationDao;

@Autowired
DonorService donorService;


@Test
void testRegisterDonor() throws DuplicateDonorException {
Donor donor = new Donor();
donor.setDonorName("harry");
donor.setDonorId(5);
donor.setDonorPhone("80803840084");
donor.setDonorEmail("harry12@gmail.com");
donor.setDonorUsername("harry12");
donor.setDonorPassword("harry@12");

Mockito.when(donorDao.save(donor)).thenReturn(donor);
boolean bool = donorService.registerDonor(donor);
assertEquals(true,bool);

}

@Test
void testLogin() throws NoSuchDonorException {
Donor donor = new Donor();
donor.setDonorName("harry");
donor.setDonorId(5);
donor.setDonorPhone("80803840084");
donor.setDonorEmail("harry12@gmail.com");
donor.setDonorUsername("harry12");
donor.setDonorPassword("harry@12");
	
Mockito.when(donorDao.findDonorByUsernameAndPassword("harry12", "harry@12")).thenReturn(donor);
boolean bool = donorService.login("harry12", "harry@12");
assertEquals(true,bool);
}

@Test
void testResetPassword() {
Donor donor = new Donor();
donor.setDonorName("harry");
donor.setDonorId(5);
donor.setDonorPhone("80803840084");
donor.setDonorEmail("harry12@gmail.com");
donor.setDonorUsername("harry12");
donor.setDonorPassword("harry@12");
	
Optional<Donor> donor1 = Optional
.of(donor);

Mockito.when(donorDao.findById(123)).thenReturn(donor1);
Mockito.when(donorDao.save(donor1.get())).thenReturn(donor1.get());

String reset = donorService.resetPassword("harry12", "harry@1234");
assertEquals("password reset successful", reset);
}


@Test
void testGetDonorById() {

Donor donor = new Donor();
donor.setDonorName("harry");
donor.setDonorId(5);
donor.setDonorPhone("80803840084");
donor.setDonorEmail("harry12@gmail.com");
donor.setDonorUsername("harry12");
donor.setDonorPassword("harry@12");
Optional<Donor> donor1 = Optional
.of(donor);
Mockito.when(donorDao.findById(5)).thenReturn(donor1);
Optional<Donor> donor2 = donorService.findDonorById(5);
assertEquals(donor1, donor2);
}

}
