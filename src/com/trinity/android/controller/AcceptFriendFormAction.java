package com.trinity.android.controller;

import java.io.Serializable;

import com.trinity.android.databeans.FriendInfoList;

public class AcceptFriendFormAction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private FriendInfoList friendinfolist;
	
	public FriendInfoList Action(FriendInfoList friendinfolist){
		
		//logic to talk to server
		
		return friendinfolist;
	}
	

}
