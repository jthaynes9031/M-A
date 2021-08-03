package midtermConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;




public class DatabaseConnection{
	
	
	
	Scanner input = new Scanner(System.in);
	Connection connection = null;
	
	
	// Constructor (connector method below main method )
	public DatabaseConnection() {

		String url = "jdbc:mysql://localhost:3306/midterm";
		String user = "root";
		String password = "Password1";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	
	//EVERYTHING RUNS ON HERE!!!
	public static void main(String[] args) {
		Employee emp = new Employee();
		Payroll pay = new Payroll();
		Benefits ben = new Benefits();
		Scanner input = new Scanner(System.in);
		

		connector();
		boolean quit = false;
		while(!quit) {
			
			System.out.println("What would you like to do");
			String choose = input.nextLine();
			
			if(choose.equals("add employee")) {	
				emp.addEmployee();	
			}
			else if(choose.equals("find employee")) {
				emp.findEmployee();	
			}
			else if(choose.equals("delete employee")) {
				
				emp.deleteEmployee();
			}
			else if(choose.equals("update employee")) {
				
				emp.updateEmployee();
			}
			else if(choose.equals("delete pay")) {
				pay.deletePay();
			}
			else if (choose.equals("quit")) {
				quit = true;
			}
			
		}
		//pay.deposit();
		//pay.setPayrate();
		//pay.findPayrate();
		//pay.updatePay();
		//ben.addBenefits();
		//ben.deleteBenefits();
		//ben.findBenefits();
		//ben.updateBenefits();

		
	}

	//connector method
	public static void connector() {
		Scanner input = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/midterm";
		String user = "root";
		String password = "Password1";
		
		//Try statement to connect to database
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
				DriverManager.getConnection(url, user, password);
				    System.out.println("Welcome");
				    //System.out.println("what would you like to do");
				    //input.nextLine();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	}catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
