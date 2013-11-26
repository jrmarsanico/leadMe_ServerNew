package server;

import database.ConnectionPool;
import database.UsersTAO;
//import helper.Constant;

import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.util.concurrent.Executors;

//import table_access_objects.*;

//import com.sun.net.httpserver.HttpServer;

public class MainServer {
	public static void main(String[] args) throws IOException {
		
		System.out.println("Connecting to the database..server start");
		long t1 = System.currentTimeMillis();
		ConnectionPool con_pool = new ConnectionPool();
		
		UsersTAO users_tao = new UsersTAO(con_pool);
		//users_tao.getUsers(1);
		users_tao.registerUser("JimmyMarsanico", "jrmarsanico@gmail.com", "dummyPassw0rd", "Available");
/*		
		LocationTAO loc_tao = new LocationTAO(con_pool);
		AwareRoomTAO aware_room_tao = new AwareRoomTAO(con_pool);
		ReservationTAO reserve_tao = new ReservationTAO(con_pool);
		TfhTAO tfh_tao = new TfhTAO(con_pool);
		
		HttpServer server = HttpServer.create(
				new InetSocketAddress(Constant.SERVER_PORT), Constant.MAX_BACKLOG);

		//Create handlers and contexts for each handler
		server.createContext("/room", new AwareRoomHandler(aware_room_tao));
		server.createContext("/location", new LocationHandler(loc_tao));
		server.createContext("/tfh", new TFHHandler(tfh_tao));
		server.createContext("/reserve", new ReservationHandler(reserve_tao));
		
		server.setExecutor(Executors.newCachedThreadPool());
		server.start(); //Start the Http Server on port Server_Port
		System.out.println("Server is listening on port 8080" );
*/
		System.out.println("Time to boot: " + (System.currentTimeMillis()-t1));
	}
}







