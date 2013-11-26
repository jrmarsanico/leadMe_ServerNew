package database;

import helper.Constant;

import java.util.*;
import java.sql.*;

/**
 * This class is used to create a connection pool which can be used to connect to databases.
 *
 */
public class ConnectionPool {
	
	
	private String databaseUrl;
	private String userName;
	private String password;
	private int conn_count;

	Vector<Connection> connectionPool = new Vector<Connection>();

	public ConnectionPool() {
		this(Constant.DB_NAME, Constant.JDBC_URL, Constant.DB_USER, Constant.DB_PASS);
	}

	public ConnectionPool(String databaseName, String url, String uname, String pwd) {
		this.databaseUrl = url.concat(databaseName);
		this.userName = uname;
		this.password = pwd;
		conn_count = 0;
		//Create a connection to start of with..
		returnConnectionToPool(createNewConnectionForPool());
	}

	//Creating a connection
	private Connection createNewConnectionForPool()
	{
		Connection connection = null;
		try {
			Class.forName(Constant.JDBC_DRIVER_NAME);
			connection = DriverManager.getConnection(databaseUrl, userName, password);
			System.out.println("Connection: "+connection);
			conn_count++;
		} catch(SQLException sqle) {
			System.err.println("SQLException: "+sqle);
			return null;
		} catch(ClassNotFoundException cnfe) {
			System.err.println("ClassNotFoundException: "+cnfe);
			return null;
		}

		return connection;
	}

	public synchronized Connection getConnectionFromPool()
	{
		Connection connection = null;

		//Check if there is a connection available. There are times when all the connections in the pool may be used up
		if(connectionPool.size() > 0) {
			connection = (Connection) connectionPool.firstElement();
			connectionPool.removeElementAt(0);
		} else { //otherwise create a new connection.
			connection = createNewConnectionForPool();
		}
		System.out.println("Remaining connections:" + connectionPool.size() + "/" + conn_count);
		//Giving away the connection from the connection pool
		return connection;
	}

	public synchronized void returnConnectionToPool(Connection connection)
	{
		//Adding the connection from the client back to the connection pool
		connectionPool.addElement(connection);
	}
	
}
