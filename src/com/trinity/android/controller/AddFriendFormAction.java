package com.trinity.android.controller;

import java.io.Serializable;

import com.trinity.android.databeans.Message;
import com.trinity.android.forms.AddFriendForm;

public class AddFriendFormAction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Message message;
	
	public Message Action(AddFriendForm addfriendform){
		//logic to talk to server
		
		return message;
		
	}
	

}
