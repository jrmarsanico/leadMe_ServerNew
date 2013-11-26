package database;

import helper.Constant;



//import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersTAO {
	
	private ConnectionPool cp;
	
	public UsersTAO(ConnectionPool cp) {
		this.cp = cp;
	}
	
	public boolean registerUser(String username, String emailaddr, String password, String status) {
		String insert_into_table = "INSERT INTO " + Constant.USERS_TABLE
				+ " (username, emailaddress, password, status) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			Connection con = cp.getConnectionFromPool();
			PreparedStatement ps = con.prepareStatement(insert_into_table);
			ps.setString(1, username);
			ps.setString(2, emailaddr);	
			ps.setString(3, password);
			ps.setString(4, status);
			ps.executeUpdate();
			cp.returnConnectionToPool(con);
		} catch (SQLException e) {
			System.out
					.println("Thread"
							+ Thread.currentThread().getId()
							+ ": An SQL exception was thrown during registration of user:"
							+ username);
			return false;
		}
		return true;
	}
	
	public boolean verifyLogin(String username, String password) {
		String retrieved_password = null;
		try {
			Connection con = cp.getConnectionFromPool();
			
			int userId = getUserId(con, username);
			String select_statement = "SELECT password FROM " + Constant.USERS_TABLE
					+ " WHERE idusers =" + userId;
			
			PreparedStatement ps = con.prepareStatement(select_statement);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				retrieved_password = rs.getString(1);
			}
			cp.returnConnectionToPool(con);
		} catch (SQLException e) {
			System.out.println("Verify Login SQL Exception");
			return false;
		} catch (Exception e) {
			System.out.println("Verify Login Exception");
			return false;
		}
		
		if(password.equals(retrieved_password)) {
			return true;
		} else {
			return false;
		}
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
	
	public boolean getUsers(Connection con, String searchCol, String searchTerm) {
		String select_statement = "SELECT username FROM " + Constant.USERS_TABLE + " WHERE " + searchCol + " LIKE '%" + searchTerm + "%'";
		try {
			PreparedStatement ps = con.prepareStatement(select_statement);
			ResultSet rs = ps.executeQuery();
			if(!rs.first())
				return false;
			String un = rs.getString(2);
			System.out.println(un);
			cp.returnConnectionToPool(con);
			return true;
		} catch (SQLException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}