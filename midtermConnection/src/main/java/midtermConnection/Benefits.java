package midtermConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Benefits extends DatabaseConnection{

	Scanner bits = new Scanner(System.in);
	String b = bits.nextLine();
	String t = "go to main";
	

	public void findBenefits() 
	{
		DatabaseConnection bitsConn = new DatabaseConnection();
		Scanner bits = new Scanner(System.in);
		
		
		try
		{
			String findBenefits = "Select * FROM benefits WHERE employee_number =?";
			PreparedStatement statement = bitsConn.connection.prepareStatement(findBenefits);
			System.out.println("Enter your employee number: ");
			statement.setString(1, bits.nextLine());
			ResultSet result1 = statement.executeQuery();
			while(result1.next()) {
				System.out.println("What benefit do you need to check?");
				String search = result1.getString(bits.nextLine());
				System.out.println("1 means you have the benefit, 0 means you don't have the benefit");
				System.out.println(search);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		bits.close();
	}
	public void addBenefits() 
	{
		DatabaseConnection bitsConn = new DatabaseConnection();
		Scanner bits = new Scanner(System.in);
		
		try
		{
			String addBenefits = "Insert INTO benefits ( FourOhONEK, HealthInsurance, DentalInsurance, PaidLeave, employee_number) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = bitsConn.connection.prepareStatement(addBenefits);
			System.out.println("Please type true for yes and false for no");
			System.out.println("Do you want 401k?");			
			statement.setBoolean(1, bits.nextBoolean());
			System.out.println("Do you want health insurance?");
			statement.setBoolean(2, bits.nextBoolean());
			System.out.println("Do you want dental insurance?");
			statement.setBoolean(3, bits.nextBoolean());
			System.out.println("Do you want paid holidays?");
			statement.setBoolean(4, bits.nextBoolean());
			System.out.println("Enter your employee number");
			statement.setInt(5, bits.nextInt());
			
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) 
			{
				System.out.println("Benefits was added");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		bits.close();
	}
	
	public void deleteBenefits() {
		DatabaseConnection bitsConn = new DatabaseConnection();
		Scanner bits = new Scanner(System.in);
		try
		{
			String deleteBenefits = "DELETE FROM benefits WHERE employee_number = ?";
			PreparedStatement statement = bitsConn.connection.prepareStatement(deleteBenefits);
			//System.out.println("What is your employee number");
			//statement.setString(1, bits.nextLine());
			System.out.println("Enter the employee number you want to delete benefits for.");
			statement.setInt(1, bits.nextInt());
			int rowsDeleted = statement.executeUpdate();
			
			if (rowsDeleted > 0) 
			{
				System.out.println("Benefits was deleted");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		bits.close();
			
		}
	public void updateBenefits() {
		 DatabaseConnection bitsConn = new DatabaseConnection();
		 Scanner bits = new Scanner(System.in);
		 try {
			 String updateEmployee = "UPDATE benefits SET FourOhONEK = ?, HealthInsurance = ?, DentalInsurance = ?, PaidLeave = ? WHERE employee_number = ?";
			 PreparedStatement statement = bitsConn.connection.prepareStatement(updateEmployee);
			 			 
			 System.out.println("Enter true for yes, false for no.");
			 System.out.println("Do you want to update 401k?");
			 statement.setBoolean(1,bits.nextBoolean());
			 System.out.println("Do you want to update health insurance?");
			 statement.setBoolean(2, bits.nextBoolean());
			 System.out.println("Do you want to update dental insurance?");
			 statement.setBoolean(3, bits.nextBoolean());
			 System.out.println("Do you want to update paid holidays?");
			 statement.setBoolean(4, bits.nextBoolean());
			 System.out.println("Enter your empoloyee number for update");
			 statement.setInt(5, bits.nextInt());
			 int rowsUpdated = statement.executeUpdate();
			 
			 if(rowsUpdated > 0) {
				 System .out.println("Benefits has been updated");
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 bits.close();
	 }
}
