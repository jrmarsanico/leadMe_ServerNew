package helper;

/**
 * This class contains all the constants used throughout the project. 
 * An effort has been made to ensure that there are no magic strings.
 * So all the strings and constants have been defined here.
 * This also promotes ease of changing variables such as the server_port.
 * 
 * @author Anish Phophaliya
 *
 */
public class Constant {
	//These are default cases and may be different on different machines. So please update accordingly.
	
	public static final int SERVER_PORT = 8080;
	
	// Database connection info
	public static final String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
	public static final String DB_USER = "root";
	public static final String DB_PASS = "cmu18641";
	public static final String DB_NAME = "leadme_db";

	// Database tables info
	public static final String USERS_TABLE = "users";
	public static final String FRIENDS_TABLE = "friends";
	public static final String GEOLOCATION_TABLE = "geolocation";
	public static final String REQUESTS_TABLE = "requests";
	public static final String LOGS_TABLE = "logs";
	
	/*
	public static final String RESERVATION_TABLE = "reservation";
	public static final String USER_TABLE = "user";
	public static final String PREF_TABLE = "preferences";
	public static final String AWARE_ROOM_TABLE = "aware_room";
	public static final String MEETING_LOGS_TABLE = "meeting_logs";
	public static final String TFH_TABLE = "TFH";
	*/
	
	// Path of log file (includes the name).
	public static final String LOG_FILE_PATH = "logs.txt";
	
	//Coordinates of Room2
	public static final double ROOM_LON = -79.9461;
	public static final double ROOM_LAT = 40.4444;
	
	// DON'T MODIFY!	
	public static final int NTHREADS = 100;
	public static final int MAX_BACKLOG = 100;	
}
