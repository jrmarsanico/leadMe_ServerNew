package com.trinity.android.databeans;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.List;

public class FriendInfoList implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Message message;
	
	private ArrayList<FriendInfo> friendInfoList = new ArrayList<FriendInfo>();
	
	
	public FriendInfoList(ArrayList<FriendInfo> friendinfolist,Message message){
		this.friendInfoList = friendinfolist;
		this.message = message;
		
	}

	public ArrayList<FriendInfo> getFriendinfolist() {
		return friendInfoList;
	}

	public void setFriendinfolist(ArrayList<FriendInfo> friendinfolist) {
		this.friendInfoList = friendinfolist;
	}

	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	

}
