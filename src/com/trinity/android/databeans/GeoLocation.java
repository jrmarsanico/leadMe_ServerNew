package com.trinity.android.databeans;

import java.io.Serializable;

public class GeoLocation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String streetName;
	String city;
	String state;
	String zipCode;
	String country;
	
	public GeoLocation(String streetName){
		this.streetName = streetName;
		this.city = "default city";
		this.state ="default state";
		this.country = "default country";
		this.zipCode = "10000";
	}
	public GeoLocation(String streetName, String city, String state,String zipCode,
			String country){
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.streetName = streetName;
		
	}
	
	
	
	public String getStreeName() {
		return streetName;
	}
	public void setStreeName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
	
	
	/* private String locationText;

	public GeoLocation(String s){
		this.locationText = s;
	}
	public String getLocationText() {
		return locationText;
	}

	public void setLocationText(String locationText) {
		this.locationText = locationText;
	}*/
	
}
