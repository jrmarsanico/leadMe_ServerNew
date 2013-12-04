package com.trinity.android.socket;
//package com.prashant.adesara.socket.server;

import database.ConnectionPool;
import database.UsersTAO;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.trinity.android.databeans.FriendInfo;
import com.trinity.android.databeans.FriendInfoList;
import com.trinity.android.databeans.FriendRequest;
import com.trinity.android.databeans.FriendRequestList;
import com.trinity.android.databeans.FriendSearchResults;
import com.trinity.android.databeans.GeoLocation;
import com.trinity.android.databeans.Message;
import com.trinity.android.databeans.SearchResult;
import com.trinity.android.databeans.UserInfo;
import com.trinity.android.forms.AddFriendForm;


/**
 * @author Prashant Adesara
 * The class extends the Thread class so we can receive and send messages at the
 * same time
 */
public class SocketMainServer extends Thread
{
	private int SERVERPORT = 5657;
	private ServerSocket serverSocket;
	private Socket client = null;
	private boolean running = false;
	private PrintWriter mOut;
    private ObjectOutputStream outputObject;
	private OnMessageReceived messageListener;
	private onClassReceived classListener;
	private ObjectInputStream inputObject;
	private int command;
	
	public static void main(String[] args)
	{
		// opens the window where the messages will be received and sent
		ServerBoard frame = new ServerBoard();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // *** center the app *** 
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor of the class
	 * @author Prashant Adesara
	 * @param messageListener listens for the messages
	 */
	public SocketMainServer(OnMessageReceived messageListener)
	{
		this.messageListener = messageListener;
	}
	
	public SocketMainServer(onClassReceived classListener)
	{
		this.classListener = classListener;
	}

	/**
	 * Method to send the messages from server to client
	 * @author Prashant Adesara
	 * @param message the message sent by the server
	 */
	public void sendMessage(String message)
	{
		try
		{
			if (mOut != null && !mOut.checkError())
			{
				System.out.println(message);
				// Here you can connect with database or else you can do what you want with static message
				mOut.println(message);
				mOut.flush();
			}
		}
		catch (Exception e)
		{
		}
	}

	public void sendClass(TestClass testclasstoClient)throws IOException
	{		
    	System.out.println("I came here");

		
		if (testclasstoClient != null){// && !outputObject.checkError()) {
			System.out.println("Server:"+testclasstoClient.getToConsole());
			//System.out.println("Server:"+testclasstoClient.getMessage().getMessage() + ","+testclasstoClient.getCOMMAND());
        	outputObject.writeObject(testclasstoClient);
            //out.println(testclass);
        	outputObject.flush();
        }
		
	}
	/**
	 * @author Prashant Adesara
	 * */
	@Override
	public void run()
	{
		super.run();
		running = true;
		try
		{
			System.out.println("PA: Connecting...");
			
			// connect to db
			System.out.println("Connecting to the database..server start");
			long t1 = System.currentTimeMillis();
			ConnectionPool con_pool = new ConnectionPool();
			
			// create a server socket. A server socket waits for requests to
			// come in over the network.
			serverSocket = new ServerSocket(SERVERPORT);

			// create client socket... the method accept() listens for a
			// connection to be made to this socket and accepts it.
			while(true){
				try {
					System.out.println("Socket created");
					client = serverSocket.accept(); // need to create new THREAD for each accept.
					System.out.println("S: Receiving...");
					// sends the message to the client
					mOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
	                
					
					
//					outputObject = new ObjectOutputStream(client.getOutputStream());
	                
					
					
					
					System.out.println("PA: Sent");
					System.out.println("PA: Connecting Done.");
					// read the message received from client
					// BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					
					
					
					
//					inputObject = new ObjectInputStream(client.getInputStream());

					
					
					
					
					//				//sendMessage("Server connected with Android Client now you can chat with socket server.");
					
					// in this while we wait to receive messages from client (it's an infinite loop)
					// this while it's like a listener for messages
					while (running)
					{
						outputObject = new ObjectOutputStream(client.getOutputStream());
						inputObject = new ObjectInputStream(client.getInputStream());
						
						 System.out.println("I am inside while.");
	
						//String message = in.readLine();
						TestClass testclassfmClient = (TestClass)inputObject.readObject();
						 System.out.println("I am about to enter if.");
	
							if (testclassfmClient != null && classListener != null)
								{
								 //System.out.println(testclassfmClient.getRegisterform().getUserName());
	
									// call the method messageReceived from ServerBoard class
									//messageListener.messageReceived(message);//(message);
									classListener.classReceived(testclassfmClient);//(message);//(message);
									command = testclassfmClient.getCOMMAND();
									 if(command == 1)
									 {
										 System.out.println("command 1");
										 UsersTAO users_tao = new UsersTAO(con_pool);
										 String username = testclassfmClient.getRegisterform().getUserName();
										 String emailaddr = testclassfmClient.getRegisterform().getUserEmail();
										 String password = testclassfmClient.getRegisterform().getPassWord();
										 boolean pass = users_tao.registerUser(username, emailaddr, password, "n/a");
										 
										 if(pass) {
											//update the DB with user registration details
											 TestClass testclasstoClient = new TestClass();
											 testclasstoClient.setMessage(new Message("Registration Successful"));
											 testclasstoClient.setCOMMAND(1);
											 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
											 sendClass(testclasstoClient);
											 System.out.println("Sent registration verification to client.");
										 } else {
											//update the DB with user registration details
											 TestClass testclasstoClient = new TestClass();
											 testclasstoClient.setMessage(new Message("Registration Failed"));
											 testclasstoClient.setCOMMAND(1);
											 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
											 sendClass(testclasstoClient);
											 System.out.println("Sent registration failure to client.");
										 }
										 
										 client.close();
									 }
									 else if (command == 2) 
									 {
										 String username_to_verify = testclassfmClient.getLoginform().getUserName();
										 String password_to_verify = testclassfmClient.getLoginform().getPassWord();
										 UsersTAO users_tao = new UsersTAO(con_pool);
										 
										 boolean pass = users_tao.verifyLogin(username_to_verify, password_to_verify);
										 
										 if(pass) {
											 TestClass testclasstoClient = new TestClass();
											 testclasstoClient.setMessage(new Message("Login Successful"));
											 testclasstoClient.setCOMMAND(2);
											 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
											 sendClass(testclasstoClient);
											 System.out.println("Sent login verification to client.");
										 } else {
											 TestClass testclasstoClient = new TestClass();
											 testclasstoClient.setMessage(new Message("Login Failed"));
											 testclasstoClient.setCOMMAND(2);
											 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
											 sendClass(testclasstoClient);
											 System.out.println("Sent login failure to client.");
										 }
										 client.close();
									 }
									 else if (command == 3)
									 {
										 // search functionality
										 FriendSearchResults fsr = new FriendSearchResults(null); // populate this from database
										 
										 TestClass testclasstoClient = new TestClass();
										 testclasstoClient.setMessage(new Message("Returning Users List"));
										 testclasstoClient.setFriendsearchresults(fsr);
										 testclasstoClient.setCOMMAND(3);
										 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
										 sendClass(testclasstoClient);
										 System.out.println("Sent friend search results to client.");
										 client.close();
									 }
									 else if (command == 4)
									 {
										 // add friend 
										 AddFriendForm aff = testclassfmClient.getAddfriendform();
										 System.out.println("Received AddFriendForm for: " + aff.getFriendName());
										 
										 TestClass testclasstoClient = new TestClass();
										 testclasstoClient.setMessage(new Message("Add Request Received"));
										 testclasstoClient.setCOMMAND(4);
										 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
										 sendClass(testclasstoClient);
										 System.out.println("Add friend received. 'Adder' was notified");
										 client.close();
									 }
									 else if (command == 5)
									 {
										 String cancel_or_accept = testclassfmClient.getToConsole();
										 // do something with the accept friend form
										 
										 // if accept....
										 // accept friend request
										 TestClass testclasstoClient = new TestClass();
										 testclasstoClient.setMessage(new Message(cancel_or_accept));
										 testclasstoClient.setCOMMAND(5);
										 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
										 sendClass(testclasstoClient);
										 System.out.println("Sent " + cancel_or_accept + " confirmation to client.");
										 
										 // else cancel...
										 // then do something with cancel
										 
										// client.close();
									 }
									 else if (command == 6)
									 {
										 TestClass testclasstoClient = new TestClass();
										 
										 System.out.println("got to 6");
										 // refresh/update friends list (with updated locations & new notifications)
										 UserInfo ui = testclassfmClient.getUserinfo();
										 String username = ui.getName();
										 
										 System.out.println("got ui");
										 
										 // get notifications for 'username' from DB, RequestioTAO.getNotifications(username);
										 Message msg = new Message("Refresh Received");
										 FriendRequest fr1 = new FriendRequest("Vaddepally");
										 FriendRequest fr2 = new FriendRequest("Marsanico");
										 
										 ArrayList<FriendRequest> fra = new ArrayList<FriendRequest>();
										 fra.add(fr1);
										 fra.add(fr2);
										 FriendRequestList frl = new FriendRequestList(fra, msg);
										 
										 System.out.println("made frl");
										 
										 // get updated user list from db 
										 // ???
										 SearchResult sr1 = new SearchResult("Srinath","Pittsburgh","USA");
										 SearchResult sr2 = new SearchResult("Jimmy","Pittsburgh","USA");
										 SearchResult sr3 = new SearchResult("Miao","Pittsburgh","USA");


										 ArrayList<SearchResult> sra = new ArrayList<SearchResult>();
										 sra.add(sr1);
										 sra.add(sr2);
										 sra.add(sr3);
										 FriendSearchResults fsr = new FriendSearchResults(sra,msg);
										
										 
										 
										 
										 
										 // get updated friend list from db
										 GeoLocation gl1 = new GeoLocation("2123ShadyAve","Pittsburgh","Pensylvania","15217","USA");
										 GeoLocation gl2 = new GeoLocation("5000ForbesAve","Pittsburgh","Pensylvania","15223","USA");

										 FriendInfo f1 = new FriendInfo("Srinath", gl1, null);
										 FriendInfo f2 = new FriendInfo("Guangyao", gl2, null);

										 
										 
										 
										 ArrayList<FriendInfo> fia = new ArrayList<FriendInfo>();
										 fia.add(f1);
										 fia.add(f2);
										 FriendInfoList fil = new FriendInfoList(fia, msg);
										 
										 
										 testclasstoClient.setFriendInfolist(fil);
										 testclasstoClient.setFriendrequestlist(frl);
										 testclasstoClient.setFriendsearchresults(fsr);
										 testclasstoClient.setMessage(msg);
										 testclasstoClient.setCOMMAND(6);
										 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
										 sendClass(testclasstoClient);
										 System.out.println("Notifications sent to user: " + username);
//										 client.close();
									 }
									 else if (command == 7) {
										 
										 String username_to_delete = testclassfmClient.getDeletefriendform().getFriendName();
										 // delete it from the db
										 System.out.println("Deleting... " + username_to_delete);
										 
										 TestClass testclasstoClient = new TestClass();
										 testclasstoClient.setMessage(new Message("Delete Confirmation"));
										 testclasstoClient.setCOMMAND(2);
										 testclasstoClient.setToConsole(testclasstoClient.getMessage().getMessage());
										 sendClass(testclasstoClient);
										 System.out.println("Sent delete confirmation to client.");
										// client.close();
									 }
	
								}
							
							//System.out.println("Time to boot: " + (System.currentTimeMillis()-t1));
							
					}
				}
				catch (Exception e)
				{
					System.out.println("client changed activity and hence running value is " + running );

					System.out.println("PA: Error: "+e.getMessage());
					e.printStackTrace();
				}
				finally
				{
					client.close();
					System.out.println("PA: Done.");
				}
			}
		}//end while(true)
		catch (Exception e)
		{
			System.out.println("PA: Error");
			e.printStackTrace();
		}
		
	}

	/**
	 * Declare the interface. The method messageReceived(String message) will
	 * @author Prashant Adesara 
	 * must be implemented in the ServerBoard
	 * class at on startServer button click
	*/
	public interface OnMessageReceived
	{
		public void messageReceived(String message);
	}
	public interface onClassReceived
	{
		public void classReceived(TestClass testclassfmClient);
	}

}
