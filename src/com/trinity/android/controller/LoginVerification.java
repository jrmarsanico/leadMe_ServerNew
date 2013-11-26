package com.trinity.android.controller;

import java.io.Serializable;

import com.trinity.android.databeans.Message;
import com.trinity.android.forms.LoginForm;

public class LoginVerification implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//socket communication with server for login verification
	
	private Message message;
	
	
	
	public Message Action(LoginForm loginform){
		//logic to talk to server
		
		return message;
	}
	

}
