package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tryout {
	
	public static String URL = "jdbc:mysql://localhost:3306/mysql";
	public static String USER = "root";
	public static String PASSWORD = "";
	
	public Tryout(){
		System.out.println("Trabajando en otra rama");
	}	
	
	public void addDoctor(String name, String surname, int day, int month, int year, int experience, String license, String dni) throws SQLException {
		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		
		String query = "insert into doctor values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, name);
		ps.setString(2, surname);
		ps.setString(3, String.valueOf(year) + "-" + String.valueOf(month) + "-"+String.valueOf(day));
		ps.setInt(4, experience);
		ps.setString(5, license);
		ps.setString(6, dni);
		
		ps.executeUpdate();
		
		con.close();
		
		System.out.println("DOCTORS TABLE UPDATED:");
		getDoctors();
	}
	
	public void addPatient(String name, String surname, int day, int month, int year, String dni) throws SQLException {
		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		
		String query = "insert into patient values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, name);
		ps.setString(2, surname);
		ps.setString(3, String.valueOf(year) + "-" + String.valueOf(month) + "-"+String.valueOf(day));
		ps.setString(4, dni);
		
		ps.executeUpdate();
		
		con.close();
		
		System.out.println("PATIENTS TABLE UPDATED:");
		getPatients();
	}
	
	public void getPatients() throws SQLException {
		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		
		String query = "select * from patient";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1) + " - " + rs.getString(2)+" - " + rs.getDate(3)+" - " + rs.getString(4));
		
		ps.close();
		rs.close();
		con.close();
		
		
	}
	
	public void getDoctors() throws SQLException {
		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		
		String query = "select * from doctor";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1) + " - " + rs.getString(2)+" - " + rs.getDate(3)+" - " + rs.getInt(4)
			+ " - " + rs.getString(5)+ " - " + rs.getString(6));
		ps.close();
		rs.close();
		con.close();
	}
}
