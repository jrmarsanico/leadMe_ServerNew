package com.trinity.android.databeans;

import java.io.Serializable;
import java.util.ArrayList;

public class FriendRequestList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<FriendRequest> friendRequestList = new ArrayList<FriendRequest>();
	private Message message;
	
	public FriendRequestList(ArrayList<FriendRequest> friendrequestlist,Message message){
		this.friendRequestList = friendrequestlist;
		this.message = message;
		
	}
	
	public ArrayList<FriendRequest> getFriendRequestList() {
		return friendRequestList;
	}
	public void setFriendRequestList(ArrayList<FriendRequest> friendRequestList) {
		this.friendRequestList = friendRequestList;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	

}
