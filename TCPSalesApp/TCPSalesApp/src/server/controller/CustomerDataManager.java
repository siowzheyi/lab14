package server.controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Product;

/**
 * This class manage customer data
 * 
 * @author Siow Zhe Yi
 *
 */
public class CustomerDataManager {

	private List<Customer> customers;
	
	/**
	 *  Constructor to call method 1
	 */
	public CustomerDataManager(){
		
		// Load customers
		this.customers = new ArrayList<Customer>();
		this.loadCustomer();
	}
	

	public List<Customer> getCustomers() {
		
		return customers;
	}

	/**
	 * This method creates a list of samples of customer
	 * data. The list will contain 10 customers. This
	 * is a private method
	 */
	private void loadCustomer() {
		
		// Sample data
		int ids[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String names[] = {"Ali", "Mac", "Mark", "Dave", "Allie",
				"Micole", "David", "Jackson", "Jay", "Evalene"};
//		double prices[] = {7.65, 9.60, 6.90};
		
		// Load data into list
		for (int index=0; index < ids.length; index++) {
			
			// Create customer
			Customer customer = new Customer();
			customer.setId(ids[index]);
			customer.setName(names[index]);
			
			// Add to list
			customers.add(customer);
			
		}
	}
	
	/**
	 * This method searches a customer based on the
	 * customer’s name from a list of customers. This
	 * method will receive a parameter that represents a
	 * customer’s name. The customer’s name will be
	 * either full or partial name. The method will return a
	 * Customer’s object if the name exists. Otherwise, it
	 * will return null. This is a public method.
	 */
	public Customer searchCustomerName(String nameString) {
		Customer customer = null;
		for(Customer customerLoop : customers)
		{
			String name = customerLoop.getName();
//			System.out.println("name checked: " + name + " and string is: " + nameString);
			if(name.contains(nameString))
				return customerLoop;
		}
		
		return customer;
	}
	

	/**
	 * This method searches a customer based on the
	 * customer’s id from a list of customers. This
	 * method will receive a parameter that represents a
	 * customer’s name. The customer’s name will be
	 * either full or partial name. The method will return a
	 * Customer’s object if the name exists. Otherwise, it
	 * will return null. This is a public method.
	 */
	public Customer searchCustomerId(String nameString) {
		
		Customer customer = null;
		for(Customer customerList : customers)
		{
			String name = customerList.getName();
			if(name.contains(nameString))
				return customerList;
			
		}
		
		return customer;
	}

	/**
	 * This method searches a customer based on the
	 * customer’s id from a list of customers. This
	 * method will receive a parameter that represents a
	 * customer’s name. The customer’s name will be
	 * either full or partial name. The method will return a
	 * Customer’s object if the name exists. Otherwise, it
	 * will return null. This is a public method.
	 */
	public Customer searchCustomerId(int id) {
		
		Customer customer = null;
		for(Customer customerList : customers)
		{
			int checkId = customerList.getId();
			if(checkId == id)
				return customerList;
		}
		
		return customer;
	}

}
