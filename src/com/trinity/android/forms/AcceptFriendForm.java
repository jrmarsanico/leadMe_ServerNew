package com.trinity.android.forms;

import java.io.Serializable;

public class AcceptFriendForm implements SendData,Serializable{
	
	private static final long serialVersionUID = 1L;

	private String friendName;
	
	public AcceptFriendForm(String friendName){
		this.friendName = friendName;
	}
	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	@Override
	public void SocketsendData() {
		// TODO Auto-generated method stub
		
	}
	

}
