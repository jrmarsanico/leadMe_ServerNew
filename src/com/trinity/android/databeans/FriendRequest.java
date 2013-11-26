package com.trinity.android.databeans;

import java.io.Serializable;

public class FriendRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String notification;

	public FriendRequest(String notification){
		this.notification = notification;
		
	}
	
	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}
	
	
}
