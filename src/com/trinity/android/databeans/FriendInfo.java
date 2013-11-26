package com.trinity.android.databeans;

import java.io.Serializable;

public class FriendInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private GeoLocation geoLocation;
	private Status status;
	
	public FriendInfo(String name, GeoLocation geoLocation, Status status){
		this.name = name;
		this.geoLocation = geoLocation;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
