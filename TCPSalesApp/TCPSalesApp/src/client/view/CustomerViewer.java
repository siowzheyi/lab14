package client.view;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Customer;

public class CustomerViewer {
	
	
	public void displayCustomers(List<Customer> customers) {
		
		// Sort in alphabetical way
		Collections.sort(customers, Comparator.comparing(Customer::getName));
		
		// Some information about the record
		System.out.println("\tNumber of record: " + customers.size());
		System.out.println("\tCustomer Information");
		
		// Print all products on console
		for (Customer customer:customers) {
			
			System.out.println("\tCustomer Id: " + customer.getId());
			System.out.println("\tName: " + customer.getName() + "\n");
		}
		
	}

}
