package com.trinity.android.controller;

import java.io.Serializable;

import com.trinity.android.databeans.Message;
import com.trinity.android.forms.RegisterForm;

public class RegisterFormVerification implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Message message;

	
	
	public Message Action(RegisterForm registerform){
		// logic to talk to server
		
		return message;
	}
}
