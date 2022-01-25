package com.workshop.biz;

import com.workshop.entity.Customer;

public interface ICustomerBiz {
	public void initializeCustomer() ;
	public void printAllCustomer();
	public void insertCustomer();
	public void insertCustomer(Customer customer);
	public void deleteCustomer();
}
