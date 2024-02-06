package airline;

import java.sql.*;

public class Conn {

	public Connection conn;
	public Statement stmt;
	
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlineproject", "root", "");
			stmt = conn.createStatement();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new Conn();
	}

}
