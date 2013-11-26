package com.trinity.android.controller;

import java.io.Serializable;

import com.trinity.android.databeans.FriendSearchResults;
import com.trinity.android.forms.SearchForm;

public class SearchAction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private FriendSearchResults friendsearchresults;

	
	

	public FriendSearchResults Action(SearchForm searchform){
		//logic to talk to server
		
		return friendsearchresults;
		
	}
	
}
