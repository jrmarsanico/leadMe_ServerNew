package com.trinity.android.forms;

import java.io.Serializable;

public class SearchForm implements SendData,Serializable{
	
	private static final long serialVersionUID = 1L;
	private String searchString;

	public SearchForm(String searchstring)
	{
		this.searchString = searchstring;
	}
	
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
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

