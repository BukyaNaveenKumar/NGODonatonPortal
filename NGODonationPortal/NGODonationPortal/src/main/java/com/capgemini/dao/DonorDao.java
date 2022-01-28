package com.capgemini.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Donor;


@Repository
public interface DonorDao extends JpaRepository<Donor,Integer> {

//public int createDonor(Donor donor);
//public int login(Donor donor);
//public Donation donateToNGO(Donation donation);

@Query("select d from Donor d where d.donorUsername = ?1 and d.donorPassword = ?2")
public Donor findDonorByUsernameAndPassword(String username,String password);

@Query("select donorPassword from Donor d where d.donorUsername = ?1 ")
public String forgotPassword(String username);

@Modifying
@Query("update Donor d set d.donorPassword = ?2 where d.donorUsername = ?1")
public void resetPassword(String username, String password);
}

