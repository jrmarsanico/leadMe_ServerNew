package com.trinity.android.forms;

import java.io.Serializable;

public class RegisterForm implements SendData,Serializable{
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userEmail;
	private String passWord;

	
	public RegisterForm(String username, String password, String useremail){
		this.userName = username;
		this.passWord = password;
		this.userEmail = useremail;
	}
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public void trim(){
		
	}
	public void validation(){
		
	}


	@Override
	public void SocketsendData() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
