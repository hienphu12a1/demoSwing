package hphu.demoSwing;

import java.sql.*;

public class demoConnection {

	public static Connection getMysqlConnection() throws SQLException, ClassNotFoundException {
		String hostname = "localhost";
		String dbname = "demojava";
		String username ="root";
		String password = "";
		return getMysqlConnection(hostname, dbname, username, password);
	}
	
	public static Connection getMysqlConnection(String hostname, String dbname, String username, String password) throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbname;
		
		Connection conn = DriverManager.getConnection(connectionURL, username, password);
		
		return conn;
		
	}
	
}
