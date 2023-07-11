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
 * Exercise 5 Finding a Customer at the Client-side by Customer Name
 * 
 * @author Siow Zhe Yi
 *
 */
public class TCPSeveralCustomerNameClientApp {
	
	public static void main (String[] args) {
		
		try {
			
			System.out.println("\tExecuting TCPSeveralCustomerNameClientApp");
		
			// Server information
			int serverPortNo = 8088;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// 1. Connect to remote machine
			Socket socket = new Socket(serverAddress, serverPortNo);
			
			// Create stream to send request
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			// 2. Send several customer names to the server
            String[] customerNames = {"Jackson","Jay"};
            dos.writeInt(customerNames.length); // Send the number of customer names

            for (String name : customerNames) {
                dos.writeUTF(name); // Send each customer name
                System.out.println("Requesting customer name: " + name);
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
