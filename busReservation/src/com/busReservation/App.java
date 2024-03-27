package com.busReservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
	
	

	public static void BookTicket(int busId,Connection con) {
		
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
		Scanner scan=new Scanner(System.in);
		int in=1;
		
		while(in!=2) {
			System.out.println("Hello there,\n 1.Book a Ticket \n 2.Exit \n Enter your option:");
			in=scan.nextInt();
		}

	}

}
