package com.ecom.model;

import java.util.Date;

public class Customer {

	private int CustomerID;
	private String CustName;
	private Date CustDob;
	private String CustEmail;
	private String CustContact;
	private String CustAddress;
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public Date getCustDob() {
		return CustDob;
	}
	public void setCustDob(Date custDob) {
		CustDob = custDob;
	}
	public String getCustEmail() {
		return CustEmail;
	}
	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}
	public String getCustContact() {
		return CustContact;
	}
	public void setCustContact(String custContact) {
		CustContact = custContact;
	}
	public String getCustAddress() {
		return CustAddress;
	}
	public void setCustAddress(String custAddress) {
		CustAddress = custAddress;
	}
	
	
}
