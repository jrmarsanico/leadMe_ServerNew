package com.trinity.android.databeans;

import java.io.Serializable;

public class SearchResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String userName;
	String City;
	String Country;
	
	public SearchResult(String userName, String City, String Country){
		this.City = City;
		this.Country = Country;
		this.userName = userName;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	
	
}
