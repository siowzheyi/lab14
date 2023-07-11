package client.app;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import model.Customer;

/**
 * This is a TCP client class that process primitive (customer id) and complex
 * (Product) data using different streams.
 * Exercise 7: Finding a Customer at the Client-Side by Customer Id
 * 
 * @author Siow Zhe Yi
 *
 */
public class TCPSeveralCustomerIDClientApp {
	
	public static void main (String[] args) {
		
		try {
			
			System.out.println("\tExecuting TCPSeveralCustomerIDClientApp");
		
			// Server information
			int serverPortNo = 8088;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 1. Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			// Create stream to send request
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			// 2. Send several customer names to the server
            int[] customerIds = {1,2};
            dos.writeInt(customerIds.length); // Send the number of customer ids

            for (int id : customerIds) {
                dos.writeInt(id); // Send each customer id
                System.out.println("Requesting customer id: " + id);
            }
			
			// Create stream to receive response from the server
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			
		      // Receive the number of customers from the server
            int numCustomers = ois.readInt();

            // Receive and process the customer objects
            for (int i = 0; i < numCustomers; i++) {
                Customer customer = (Customer) ois.readObject();
                System.out.println("Received customer information (From the server)");
                if (customer != null) {
                    System.out.println("Customer Id: " + customer.getId());
                    System.out.println("Name: " + customer.getName());
                } else {
                    System.out.println("Customer not found.");
                }
            }
			
			
		} catch (Exception ex) {
			
			
			
		}
		
		
		
		
		
		
	}

}
