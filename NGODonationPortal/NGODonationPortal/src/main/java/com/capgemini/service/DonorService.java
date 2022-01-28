package com.capgemini.service;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.model.Donation;
import com.capgemini.model.Donor;

@Repository
public interface DonorService {

public boolean registerDonor(Donor donor) throws DuplicateDonorException;
public boolean login(String username,String password) throws NoSuchDonorException;
public Donation donateToNGO(Donation donation);
public void sendThankyouMailToDonator(Donor donor);
public String forgotPassword(String username);
public String resetPassword(String username,String newPassword);
public void emailPasswordToDonor(String email);
public Optional<Donor> findDonorById(int i);

}