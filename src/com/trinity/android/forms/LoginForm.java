package com.trinity.android.forms;

import java.io.Serializable;

public class LoginForm implements SendData,Serializable{
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	
	public LoginForm(String username, String password){
		this.userName = username;
		this.passWord = password;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public void trim(){
		//trim the email string 
	}

	public void validation(){
		//validation of the email address;
	}


	@Override
	public void SocketsendData() {
		// TODO Auto-generated method stub
		
	}
	

}
