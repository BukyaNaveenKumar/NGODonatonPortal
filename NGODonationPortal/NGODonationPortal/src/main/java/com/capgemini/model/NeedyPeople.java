package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class NeedyPeople {

@Id
private int needyPersonId;
private String needyPersonName;
private String phone;
private double familyIncome;

@OneToOne
private Address address;
public int getNeedyPersonId() {
return needyPersonId;
}
public void setNeedyPersonId(int needyPersonId) {
this.needyPersonId = needyPersonId;
}
public String getNeedyPersonName() {
return needyPersonName;
}
public void setNeedyPersonName(String needyPersonName) {
this.needyPersonName = needyPersonName;
}
public String getPhone() {
return phone;
}
public void setPhone(String phone) {
this.phone = phone;
}
public double getFamilyIncome() {
return familyIncome;
}
public void setFamilyIncome(double familyIncome) {
this.familyIncome = familyIncome;
}
public Address getAddress() {
return address;
}
public void setAddress(Address address) {
this.address = address;
}
@Override
public String toString() {
return "NeedyPeople [needyPersonId=" + needyPersonId + ", needyPersonName=" + needyPersonName + ", phone="
+ phone + ", familyIncome=" + familyIncome + ", address=" + address + "]";
}


}
