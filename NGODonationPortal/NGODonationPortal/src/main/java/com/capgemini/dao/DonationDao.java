package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Donation;

public interface DonationDao extends JpaRepository<Donation, Integer> {

}