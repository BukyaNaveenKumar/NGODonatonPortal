package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DonationBox {

@Id
@Column(length = 10)
private String registrationNumber;
private String ngoName;
private String accountNumber;
private double totalCollection;
public String getNgoName() {
return ngoName;
}
public void setNgoName(String ngoName) {
this.ngoName = ngoName;
}
public String getRegistrationNumber() {
return registrationNumber;
}
public void setRegistrationNumber(String registrationNumber) {
this.registrationNumber = registrationNumber;
}
public String getAccountNumber() {
return accountNumber;
}
public void setAccountNumber(String accountNumber) {
this.accountNumber = accountNumber;
}
public double getTotalCollection() {
return totalCollection;
}
public void setTotalCollection(double totalCollection) {
this.totalCollection = totalCollection;
}
@Override
public String toString() {
return "DonationBox [ngoName=" + ngoName + ", registrationNumber=" + registrationNumber + ", accountNumber="
+ accountNumber + ", totalCollection=" + totalCollection + "]";
}

}
