package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DonationItem {

@Id
private int itemId;
private DonationType item;
private String itemDescription;
public int getItemId() {
return itemId;
}
public void setItemId(int itemId) {
this.itemId = itemId;
}
public DonationType getItem() {
return item;
}
public void setItem(DonationType item) {
this.item = item;
}
public String getItemDescription() {
return itemDescription;
}
public void setItemDescription(String itemDescription) {
this.itemDescription = itemDescription;
}
@Override
public String toString() {
return "DonationItem [itemId=" + itemId + ", item=" + item + ", itemDescription=" + itemDescription + "]";
}



}
