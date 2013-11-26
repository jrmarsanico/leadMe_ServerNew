package com.trinity.android.databeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FriendSearchResults implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<SearchResult> searchResults ;
	private Message message;
	public FriendSearchResults(ArrayList<SearchResult> searchresults,Message message){
		this.searchResults = searchresults;
		this.message = message;
	}
	
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public FriendSearchResults(ArrayList<SearchResult> searchresults){
		this.searchResults = searchresults;
	}

	public List<SearchResult> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(ArrayList<SearchResult> searchResults) {
		this.searchResults = searchResults;
	}
	
	
	

}
