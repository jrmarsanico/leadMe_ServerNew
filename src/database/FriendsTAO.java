package database;

import helper.Constant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendsTAO {
	
	private ConnectionPool cp;
	
	public FriendsTAO(ConnectionPool cp) {
		this.cp = cp;
	}
	
	public boolean addFriendConnection(String user1, String user2) {
		String insert_into_table = "INSERT INTO " + Constant.FRIENDS_TABLE
				+ " (userid, friendid) "
				+ "VALUES (?, ?)";
		//insert_into_table = "insert into friends (userid,friendid) values (2,3)";
		try {
			Connection con = cp.getConnectionFromPool();
			
			System.out.println("here1");
			// get userid's from usernames
			int user_id = getUserId(con, user1); // get id from user1
			System.out.println("here2");
			
			int friend_id = getUserId(con, user2); // get id from user2
			
			PreparedStatement ps = con.prepareStatement(insert_into_table);
			ps.setInt(1, user_id);
			ps.setInt(2, friend_id);
			System.out.println("here3");
//			PreparedStatement ps = con.prepareStatement(insert_into_table);
			if(user_id!=0 && friend_id!=0)
				ps.executeUpdate();
			cp.returnConnectionToPool(con);
			
		} catch (SQLException e) {
			System.out.println("Friend SQL Exception");
		} catch (Exception e) {
			System.out.println("Friend Other Exception");
		}
		
		return true;
	}
	
	public int getUserId(Connection con, String username) {
		int id = 0;
		String select_statement = "SELECT idusers FROM " + Constant.USERS_TABLE
				+ " WHERE username = '" + username + "'";
		try {
			PreparedStatement ps = con.prepareStatement(select_statement);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { 
				id = rs.getInt(1); // returns only first result
			}
			cp.returnConnectionToPool(con);
		} catch (SQLException e) {
			System.out.println("Get UserID SQL Exception");
		} catch (Exception e) {
			System.out.println("Get UserID Exception");
		}
		return id;
	}
}
