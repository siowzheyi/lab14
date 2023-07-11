package server.app;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Customer;
import server.controller.CustomerDataManager;

public class TCPCustomerNameServerApp {

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
				
				Customer customer = null;
				// 3. Accept request from client
				Socket clientSocket = serverSocket.accept();
				
				// 4. Process request - create input stream to read request
				// Request - customer id:int
				InputStream is = clientSocket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				
				// Read customer id from client
//				int customerId = dis.readInt();
//				for (int counter = 0; counter < 2; counter++)
//				{
					String name = dis.readUTF();
					System.out.println("\n\tRequest for customer name: " + name);
					
//				}
				
//				String name = dis.readLine();
				// 5. Respond to client
				OutputStream os  = clientSocket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				// Get product
				customer = manager.searchCustomerName(name);
				
				oos.writeObject(customer);
				if(customer != null)
				System.out.print("\tSending customer: " + customer.getId()
						+ " " + customer.getName());
				else
					System.out.print("\tSending customer: null\n");
				
				
				
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}
	

}
