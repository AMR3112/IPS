package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tryout {
	
	public static String URL = "jdbc:mysql://localhost:3306/mysql";
	public static String USER = "root";
	public static String PASSWORD = "";
	
	public static void main(String args[]) {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from patient");
			while(rs.next()) {
				System.out.println(rs.getString(1) + " - " +rs.getString(2) + "\n");
			}
			
			con.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
