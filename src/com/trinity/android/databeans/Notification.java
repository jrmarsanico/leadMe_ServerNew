package com.trinity.android.databeans;

import java.io.Serializable;

public class Notification implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	
	public Notification(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
