package midtermConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Payroll extends Employee {
	DatabaseConnection databaseConn = new DatabaseConnection();
	//Employee emp = new Employee();
	Scanner input = new Scanner(System.in);
	

	//set pay rate
	public void setPayrate(){
		//add pay rate to specific employee
		
		try {
			
			String payRate = "INSERT INTO payroll (pay_rate, employee_number) values (?, ?)";
			PreparedStatement statement = databaseConn.connection.prepareStatement(payRate);
			System.out.println("Choose the hourly rate?");
			statement.setString(1, myObj.nextLine());
			System.out.println("Enter the employee number");
			statement.setString(2, myObj.nextLine());
			
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				System.out.println("pay rate is set");
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}

	//thursday
	//retrieve employee pay rate
	public void findPayrate() {
		//find employee pay rate
		
		try
		{
			String findPayRate = "SELECT * FROM payroll WHERE employee_number = ?";
			PreparedStatement statement = databaseConn.connection.prepareStatement(findPayRate);
			System.out.println("What is the employee_id for the pay you would like to view?");
			statement.setString(1, myObj.nextLine());
			ResultSet result1 = statement.executeQuery(findPayRate);
			while(result1.next()) {
				//System.out.println("pay rate for who");
				String find = result1.getString(myObj.nextLine());
				System.out.println(find);	
			}
		 	 
		}catch(Exception e){
		 e.printStackTrace();
		}
	}
	//thursday possible
	//net pay
	public void netPay() {
		//HOLD OFF
		//calculations
		
	}
	
	//thursday
	// Update Pay
	public void updatePay() {
		DatabaseConnection bitsConn = new DatabaseConnection();
		Scanner bits = new Scanner(System.in);
		try {
		 String updatePay = "UPDATE payroll SET pay_rate = ?, direct_deposit = ? WHERE employee_number = ?";
		 PreparedStatement statement = bitsConn.connection.prepareStatement(updatePay);
		 			 
		
		 System.out.println("What do we set pay rate to?");
		 statement.setInt(1, bits.nextInt());
		 System.out.println("Do you want direct deposit?");
		 statement.setBoolean(2, bits.nextBoolean());
		 System.out.println("Enter your empoloyee number for update");
		 statement.setInt(3, bits.nextInt());
		 int rowsUpdated = statement.executeUpdate();
		 
		 if(rowsUpdated > 0) {
			 System .out.println("Benefits has been updated");
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 bits.close();// ability to update pay rate
	}

	//thursday(remedial gal)
	//delete Pay
	public void deletePay() {
		
		try
		{
		String deletePay = " DELETE FROM payroll WHERE employee_number = ?";
		 PreparedStatement statement = databaseConn.connection.prepareStatement(deletePay);
		 System.out.println("What is the id of the employee whose pay you would like to delete");
		 statement.setString(1, myObj.nextLine());
		 int rowsDeleted = statement.executeUpdate();
		 
		 if(rowsDeleted > 0) {
			 System.out.println("Pay rate has been deleted");
		 }
		
			 
		}catch(Exception e){
		 e.printStackTrace();
		}
	}
	
	
	//thursday(marquez)
	//direct deposit boolean
	public void deposit() {
		
		try
		{
		String changeDeposit = "UPDATE payroll SET direct_deposit = ? WHERE employee_number = ?";
		PreparedStatement statement = databaseConn.connection.prepareStatement(changeDeposit);
		
		System.out.println("Do you want direct deposit?");
		statement.setBoolean(1, input.nextBoolean());
		System.out.println("type employee number");
		statement.setInt(2, input.nextInt());
		int rowsUpdated = statement.executeUpdate();
		 
		 if(rowsUpdated > 0) {
			 System .out.println("direct deposit has been changed");
		 }
		}catch(Exception e) {
			 e.printStackTrace();
		 }
		 input.close();
	}
	
	//gross Pay
	public void grossPay() {
		// the net pay
		//benefits
	}
	
	//public void method(int arr[]) {
		
	//}

}
