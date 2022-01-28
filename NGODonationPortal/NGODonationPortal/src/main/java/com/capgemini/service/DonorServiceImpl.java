package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.dao.DonationDao;
import com.capgemini.dao.DonorDao;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.model.Donation;
import com.capgemini.model.Donor;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {
@Autowired
DonorDao donorDao;

@Autowired
DonationDao donationDao;
@Override
public boolean registerDonor(Donor donor) throws DuplicateDonorException {
// TODO Auto-generated method stub
Donor d1 = donorDao.save(donor);

if(d1 == null) {
return false;
}
else {
return true;
}
}

@Override
public boolean login(String username, String password) throws NoSuchDonorException {
// TODO Auto-generated method stub
Donor d1 = donorDao.findDonorByUsernameAndPassword(username,password);
if(d1 == null) {
return false;
}
else {
return true;
}
}

@Override
public Donation donateToNGO(Donation donation) {
// TODO Auto-generated method stub
return donationDao.save(donation);
}

@Override
public void sendThankyouMailToDonator(Donor donor) {
// TODO Auto-generated method stub

}

@Override
public String forgotPassword(String username) {
// TODO Auto-generated method stub
return donorDao.forgotPassword(username);


}

@Override
public String resetPassword(String username,String newPassword) {
// TODO Auto-generated method stub
donorDao.resetPassword(username,newPassword);
return "password reset successful";
}

@Override
public void emailPasswordToDonor(String email) {
// TODO Auto-generated method stub

}

public Optional<Donor> findDonorById(int donorId){
return donorDao.findById(donorId);

}
   
public List<Donor> findAllDonors(){
return donorDao.findAll();
}
}
