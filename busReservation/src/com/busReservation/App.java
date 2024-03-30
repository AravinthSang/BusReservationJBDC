package com.busReservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservationsys?user=root&password=root");
	}

	public static void BookTicket( Connection con) throws SQLException {
		int busid;
		String date;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter bus id");
		busid=scan.nextInt();
		System.out.println("Enter date of journey");
		date=scan.next();
		
		PreparedStatement statement = con.prepareStatement("select * from busticket where BusId=? AND Date=?");
		statement.setInt(1, busid);
		statement.setString(2, date);
		ResultSet result = statement.executeQuery();
		if(result.next()) {//returns true if theres rpw in DB 
			
			statement =con.prepareStatement("SELECT AvailableSeat FROM busreservationsys.busticket WHERE BusId=? AND Date =?;");
			statement.setInt(1, busid);
			statement.setString(2, date);
			ResultSet executeQuery = statement.executeQuery();
			executeQuery.next();
			int availableSeats=executeQuery.getInt(1);
			
			if(availableSeats==0) {
				System.out.println("No seats are available");
			}else {
				statement=con.prepareStatement("INSERT INTO `busreservationsys`.`ticket` ( `date`, `seat`, `busid`) VALUES ( ?, ?, ?);");
				statement.setString(1, date);
				statement.setInt(2,(availableSeats-1));
				statement.setInt(3, busid);
				int executeUpdate = statement.executeUpdate();
				if(executeUpdate>0) {
					
					statement=con.prepareStatement("UPDATE `busreservationsys`.`busticket` SET `AvailableSeat` = ? WHERE (`Id` = ?);");
					statement.setInt(1, availableSeats-1);
					statement.setInt(2, busid);
					int affectedRows=statement.executeUpdate();
					if(affectedRows>0) {
						System.out.println("Bus ticket booked");
					}else {
						System.out.println("Booking failed");
					}
						
				}
			}
			
			
		}else {
			System.out.print("Sorry,Bus is Not available on that date");
		}
	}

	public static void askForInput() throws SQLException {
		Scanner scan = new Scanner(System.in);
		int in = 1;
		
		while (in != 2) {
			System.out.println("Hello there,\n 1.Book a Ticket \n 2.Exit \n Enter your option:");
			in = scan.nextInt();
			if(in==1) {
				BookTicket(getConnection());
			}
		}

	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		askForInput();
	}

}
