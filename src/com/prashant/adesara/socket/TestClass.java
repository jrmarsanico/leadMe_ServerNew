package com.prashant.adesara.socket;

import java.io.Serializable;

import com.trinity.android.databeans.*;
import com.trinity.android.controller.*;
import com.trinity.android.forms.*;



public class TestClass implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/* private TCPClient mTcpClient = null;
    private connectTask conctTask = null;
    TestClass testclassfmServer = new TestClass();*/

	/* parentClass contains all possible databean classes */
	private int COMMAND;
	
	/*Databeans*/
	private FriendInfo friendInfo;
	private FriendInfoList friendInfolist;
	private FriendRequest friendRequest;
	private FriendSearchResults friendsearchresults;
	private GeoLocation geoLocation;
	private Message message;
	private Notification notification;
	private SearchResult searchresult;
	private Status status;
	private User user;
	private UserInfo userinfo;
	private FriendRequestList friendrequestlist;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public FriendRequestList getFriendrequestlist() {
		return friendrequestlist;
	}
	public void setFriendrequestlist(FriendRequestList friendrequestlist) {
		this.friendrequestlist = friendrequestlist;
	}
	/*Controller*/
	private AcceptFriendFormAction acceptfriendformaction;
	private AddFriendFormAction addfriendformaction;
	private LoginVerification loginverification;
	private RegisterFormVerification registerformverification;
	private SearchAction searchaction;
	
	/*Forms*/
	private AcceptFriendForm acceptfriendform;
	private AddFriendForm addfriendform;
	private CancelFriendForm cancelfriendform;
	private DeleteFriendForm deletefriendform;
	private LoginForm loginform;
	private RefreshForm refreshform;
	private RegisterForm registerform;
	private SearchForm searchform;
	
	/*For the console*/
	private String toConsole;
	
	//private User user;
	//private UserInfo userInfo;
	public int getCOMMAND() {
		return COMMAND;
	}
	public FriendInfoList getFriendInfolist() {
		return friendInfolist;
	}
	public void setFriendInfolist(FriendInfoList friendInfolist) {
		this.friendInfolist = friendInfolist;
	}
	public FriendSearchResults getFriendsearchresults() {
		return friendsearchresults;
	}
	public void setFriendsearchresults(FriendSearchResults friendsearchresults) {
		this.friendsearchresults = friendsearchresults;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public SearchResult getSearchresult() {
		return searchresult;
	}
	public void setSearchresult(SearchResult searchresult) {
		this.searchresult = searchresult;
	}
	public AcceptFriendFormAction getAcceptfriendformaction() {
		return acceptfriendformaction;
	}
	public void setAcceptfriendformaction(
			AcceptFriendFormAction acceptfriendformaction) {
		this.acceptfriendformaction = acceptfriendformaction;
	}
	public AddFriendFormAction getAddfriendformaction() {
		return addfriendformaction;
	}
	public void setAddfriendformaction(AddFriendFormAction addfriendformaction) {
		this.addfriendformaction = addfriendformaction;
	}
	public LoginVerification getLoginverification() {
		return loginverification;
	}
	public void setLoginverification(LoginVerification loginverification) {
		this.loginverification = loginverification;
	}
	public RegisterFormVerification getRegisterformverification() {
		return registerformverification;
	}
	public void setRegisterformverification(
			RegisterFormVerification registerformverification) {
		this.registerformverification = registerformverification;
	}
	public SearchAction getSearchaction() {
		return searchaction;
	}
	public void setSearchaction(SearchAction searchaction) {
		this.searchaction = searchaction;
	}
	public AcceptFriendForm getAcceptfriendform() {
		return acceptfriendform;
	}
	public void setAcceptfriendform(AcceptFriendForm acceptfriendform) {
		this.acceptfriendform = acceptfriendform;
	}
	public AddFriendForm getAddfriendform() {
		return addfriendform;
	}
	public void setAddfriendform(AddFriendForm addfriendform) {
		this.addfriendform = addfriendform;
	}
	public LoginForm getLoginform() {
		return loginform;
	}
	public void setLoginform(LoginForm loginform) {
		this.loginform = loginform;
	}
	public RefreshForm getRefreshform() {
		return refreshform;
	}
	public void setRefreshform(RefreshForm refreshform) {
		this.refreshform = refreshform;
	}
	public RegisterForm getRegisterform() {
		return registerform;
	}
	public void setRegisterform(RegisterForm registerform) {
		this.registerform = registerform;
	}
	public SearchForm getSearchform() {
		return searchform;
	}
	public void setSearchform(SearchForm searchform) {
		this.searchform = searchform;
	}
	public void setCOMMAND(int cOMMAND) {
		COMMAND = cOMMAND;
	}
	public FriendInfo getFriendInfo() {
		return friendInfo;
	}
	public void setFriendInfo(FriendInfo friendInfo) {
		this.friendInfo = friendInfo;
	}
	public FriendRequest getFriendRequest() {
		return friendRequest;
	}
	public void setFriendRequest(FriendRequest friendRequest) {
		this.friendRequest = friendRequest;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getToConsole() {
		return toConsole;
	}
	public void setToConsole(String toConsole) {
		this.toConsole = toConsole;
	}
	public CancelFriendForm getCancelfriendform() {
		return cancelfriendform;
	}
	public void setCancelfriendform(CancelFriendForm cancelfriendform) {
		this.cancelfriendform = cancelfriendform;
	}
	public DeleteFriendForm getDeletefriendform() {
		return deletefriendform;
	}
	public void setDeletefriendform(DeleteFriendForm deletefriendform) {
		this.deletefriendform = deletefriendform;
	}
	
	/* public void sendtoServer(){
		// logic to talk to server

	    mTcpClient = null;
	    // connect to the server
	    conctTask = new connectTask();
	    conctTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	    
	    System.out.println("I am at 1");
	    	            	
    	
    	//System.out.println("I am at 2");
    	
        //sends the message to the server
        if (mTcpClient != null) 
        {
            //mTcpClient.sendMessage("Android Client: "+message);
        	 try {

				mTcpClient.sendClass(this);

	            	//Toast.makeText(getApplicationContext(), testclasstoServer.getToConsole(), Toast.LENGTH_LONG).show();

        	 	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }	
	}
	
	 public class connectTask extends AsyncTask<TestClass,TestClass,TCPClient> {
	        @Override
	        protected TCPClient doInBackground(TestClass... testclass) 
	        {
	            //we create a TCPClient object and
	        	 mTcpClient = new TCPClient(new TCPClient.OnClassReceived()
	            {
	                @Override
	                //here the classReceived method is implemented
	                public void classReceived(TestClass testclass) 
	                {
	                	testclassfmServer = (TestClass)testclass;
	                	
	                	try
						{
	                		//this method calls the onProgressUpdate
	                		publishProgress(testclass);
	                		if(testclass!=null) // && testclass.getMessage().getMessage() == "pass")
	                		{   //testclass contains response from server
	                			if(testclass.getMessage().getMessage().equalsIgnoreCase("pass"))
	                				{
	                				System.out.println("Return Message from Socket::::: >>>>> "+ testclass.getMessage().getMessage());
	                			
	                				}
	               	         	
	                			
	                		}
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
	                }
	            });
	            mTcpClient.run();
	            if(mTcpClient!=null)
	            {
	            	//mTcpClient.sendMessage("Initial Message when connected with Socket Server");
	           /  	try {
						mTcpClient.sendClass(this);
				    	System.out.println("I am at 5");

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	            }
	            return null;
	        }
	 
	        @Override
	        protected void onProgressUpdate(TestClass... values) {
	            super.onProgressUpdate(values);
	 
	            
	        }
	        
	        
	      
	    }

	   // @Override
	    protected void onDestroy()
	    {
	    	try
			{
	    		System.out.println("onDestroy.");
				//mTcpClient.sendMessage("bye");
				mTcpClient.stopClient();
				conctTask.cancel(true);
				conctTask = null;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	    	//super.onDestroy();
	    }  */
	
}
