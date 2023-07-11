package server.app;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Customer;
import server.controller.CustomerDataManager;

public class TCPSeveralCustomerNameServerApp {

	public static void main(String[] args) {
		
		int portNo = 8088;
		
//		ProductDataManager manager = new ProductDataManager();
		CustomerDataManager manager = new CustomerDataManager();
		System.out.println("\n\tExecuting TCPCustomerServerApp");
		
		try {
			
			System.out.println("\tWaiting for next request");
			
			// 1. Bind to a port
			ServerSocket serverSocket = new ServerSocket(portNo); 
			
			// 2. Server need to continually run to listen to request
			while (true) {
				
//				Customer customer = null;
				// 3. Accept request from client
				Socket clientSocket = serverSocket.accept();
				
				// 4. Process request - create input stream to read request
				InputStream is = clientSocket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				// 5. Respond to client
				OutputStream os  = clientSocket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				
				// Read customer id from client
				// Read the number of customer names from the client
                int numNames = dis.readInt();
                System.out.println("Request for customer names: " + numNames);

                // Create an array to store the customers
                Customer[] customers = new Customer[numNames];

                // Process each customer name
                for (int i = 0; i < numNames; i++) {
                    String name = dis.readUTF();
                    System.out.println("\nRequest for customer name: " + name);

                    // Get the customer from the data manager
                    customers[i] = manager.searchCustomerName(name);
                }
                
                // Send the customer object to the client
                oos.writeInt(customers.length); // Send the number of customers

                // only send one customer object
                if(customers[0] != null)
                {
                	oos.writeObject(customers[0]);
                	System.out.print("\tSending customer: " + customers[0].getId()
                	+ " " + customers[0].getName());                    	
                }
				else
					System.out.print("\tSending customer: null\n");
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}
	

}
