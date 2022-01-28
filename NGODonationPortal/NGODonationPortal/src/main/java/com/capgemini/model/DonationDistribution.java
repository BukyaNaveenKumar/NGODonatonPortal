package com.capgemini.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DonationDistribution {

@Id
private int distributionId;

@OneToOne
private NeedyPeople person;
@OneToOne
private DonationItem item;
@OneToOne
private Employee distributedBy;
private double amountDistributed;
private Date dateOfDistribution;
private Date approvalOrRejectedDate;
private DonationDistributionStatus status;
public int getDistributionId() {
return distributionId;
}
public void setDistributionId(int distributionId) {
this.distributionId = distributionId;
}
public NeedyPeople getPerson() {
return person;
}
public void setPerson(NeedyPeople person) {
this.person = person;
}
public DonationItem getItem() {
return item;
}
public void setItem(DonationItem item) {
this.item = item;
}
public Employee getDistributedBy() {
return distributedBy;
}
public void setDistributedBy(Employee distributedBy) {
this.distributedBy = distributedBy;
}
public double getAmountDistributed() {
return amountDistributed;
}
public void setAmountDistributed(double amountDistributed) {
this.amountDistributed = amountDistributed;
}
public Date getDateOfDistribution() {
return dateOfDistribution;
}
public void setDateOfDistribution(Date dateOfDistribution) {
this.dateOfDistribution = dateOfDistribution;
}
public Date getApprovalOrRejectedDate() {
return approvalOrRejectedDate;
}
public void setApprovalOrRejectedDate(Date approvalOrRejectedDate) {
this.approvalOrRejectedDate = approvalOrRejectedDate;
}
public DonationDistributionStatus getStatus() {
return status;
}
public void setStatus(DonationDistributionStatus status) {
this.status = status;
}
@Override
public String toString() {
return "DonationDistribution [distributionId=" + distributionId + ", person=" + person + ", item=" + item
+ ", distributedBy=" + distributedBy + ", amountDistributed=" + amountDistributed
+ ", dateOfDistribution=" + dateOfDistribution + ", approvalOrRejectedDate=" + approvalOrRejectedDate
+ ", status=" + status + "]";
}


}
