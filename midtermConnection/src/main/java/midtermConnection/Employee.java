package midtermConnection;


import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Employee{
	
	DatabaseConnection databaseConn = new DatabaseConnection();
	Scanner myObj = new Scanner(System.in);


	

	public void employeeAtt() {
		
		try
		{
			String employeeClockIn = "UPDATE employee SET attendance = ? WHERE employee_number = ? ";
			PreparedStatement statement = databaseConn.connection.prepareStatement(employeeClockIn);
			System.out.println("clocking in type '1' clocking out type '0' ");
			statement.setInt(1, myObj.nextInt());
			System.out.println("enter employee number");
			statement.setInt(2,myObj.nextInt());
			
			String attendance = "SELECT * FROM employee WHERE employee_number = ? ";
			PreparedStatement statement1 = databaseConn.connection.prepareStatement(attendance);
			System.out.println("Confirm employee number");
			statement1.setInt(1,myObj.nextInt());
			statement.addBatch();
			ResultSet rs = statement1.executeQuery(attendance);
			



			while(rs.absolute(1)) { 
			int inOrOut = rs.getInt("attendance");
						
			if(inOrOut == 1) {
				System.out.println("You're In");
			}
			if(inOrOut == 0){
				System.out.println("You're out");
			}	
		}	
		}catch(Exception e){
			System.out.println("employee not found");
		}
	}
	public void findEmployee() { 
		try 
		{
		
		String findEmployee = "SELECT * FROM employee WHERE first_name = ?";
		PreparedStatement statement = databaseConn.connection.prepareStatement(findEmployee);
		System.out.println("Enter First name");
		statement.setString(1, myObj.nextLine());
		ResultSet result1 = statement.executeQuery();
		while(result1.next()) {
			
			System.out.println("what are you looking for?");
			String find = result1.getString(myObj.nextLine());
			System.out.println(find);	
		}
		
		}catch (Exception e) {
			e.printStackTrace();			
	}	
}
	
	 public void addEmployee() {
		 try 
			{			
		    String addEmployee = "INSERT INTO employee (first_name, last_name, email, address, employee_number) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = databaseConn.connection.prepareStatement(addEmployee);
			
			System.out.println("add firstname");
			statement.setString(1, myObj.nextLine());
			System.out.println("add lastname");
			statement.setString(2, myObj.nextLine());
			System.out.println("add email");
			statement.setString(3, myObj.nextLine());
			System.out.println("add address");
			statement.setString(4, myObj.nextLine());
			System.out.println("add 4 employee number");
			statement.setInt(5,myObj.nextInt());
			
			
				
			int rowsInserted = statement.executeUpdate();
			 
			if(rowsInserted > 0 ) {
				System.out.println("New user was added");
			}
			
			
			}catch (Exception e){
				e.printStackTrace();
				
		}
			}
	 
	 
	 public void deleteEmployee() {
		 try {
			 String deleteEmployee = " DELETE FROM employee WHERE first_name = ?";
			 PreparedStatement statement = databaseConn.connection.prepareStatement(deleteEmployee);
			 System.out.println("What is the first name of the employee that you would like to delete");
			 statement.setString(1, myObj.nextLine());
			 int rowsDeleted = statement.executeUpdate();
			 
			 if(rowsDeleted > 0) {
				 System.out.println("User has been deleted");
			 }
			 
		 }catch(Exception e){
			 e.printStackTrace();
		
		 }
	 }
	 public void updateEmployee() {
		 try {
			 String updateEmployee = "UPDATE employee SET first_name = ?, last_name = ?, email = ?, address = ? WHERE employee_number = ?";
			 PreparedStatement statement = databaseConn.connection.prepareStatement(updateEmployee);
			 			 
			 //System.out.println("Follow prompt below: ");
			// myObj.next();
			 System.out.println("Keep first name or update first name to: ");
			 statement.setString(1, myObj.nextLine());
			 System.out.println("Keep last name or update  last name to: ");
			 statement.setString(2, myObj.nextLine());
			 System.out.println("Keep email or update email to:");
			 statement.setString(3,myObj.nextLine());
			 System.out.println("Keep address or update address to: ");
			 statement.setString(4,myObj.nextLine());
			 System.out.println("Enter employee number for update");
			 statement.setInt(5,myObj.nextInt());
			 int rowsUpdated = statement.executeUpdate();
			 
			 if(rowsUpdated > 0) {
				 System.out.println("User has been updated");
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
	 }
}
