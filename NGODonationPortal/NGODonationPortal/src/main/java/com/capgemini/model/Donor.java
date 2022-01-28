package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Donor {

@Id
private int donorId;
private String donorName;
private String donorEmail;
private String donorPhone;
private String donorUsername;
private String donorPassword;
@OneToOne
private Address address;
public int getDonorId() {
return donorId;
}
public void setDonorId(int donorId) {
this.donorId = donorId;
}
public String getDoorName() {
return donorName;
}
public void setDonorName(String donorName) {
this.donorName = donorName;
}
public String getDonorEmail() {
return donorEmail;
}
public void setDonorEmail(String donorEmail) {
this.donorEmail = donorEmail;
}
public String getDonorPhone() {
return donorPhone;
}
public void setDonorPhone(String donorPhone) {
this.donorPhone = donorPhone;
}
public String getDonorUsername() {
return donorUsername;
}
public void setDonorUsername(String donorUsername) {
this.donorUsername = donorUsername;
}
public String getDonorPassword() {
return donorPassword;
}
public void setDonorPassword(String donorPassword) {
this.donorPassword = donorPassword;
}
public Address getAddress() {
return address;
}
public void setAddress(Address address) {
this.address = address;
}
@Override
public String toString() {
return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", donorEmail=" + donorEmail + ", donorPhone="
+ donorPhone + ", donorUsername=" + donorUsername + ", donorPassword=" + donorPassword + ", address="
+ address + "]";
}


}

