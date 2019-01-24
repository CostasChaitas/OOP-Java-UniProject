package training.center.tub;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import training.center.tub.Controllers.GenericController;
import training.center.tub.Models.Student;

public class DBconnection {

    private static String dbUrl = "jdbc:mysql://localhost:3306/tubWinterUniversity";
    private static String dbUsername = "root";
    private static String dbPassword = "jackripper12";

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
    	 Connection conn = null;
    	 try{
    		 conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    		 return conn;
    	 }
    	 
    	 catch(SQLException se){
    		 //Handle errors for JDBC
    		 se.printStackTrace();
   	   	 }
    	 
		return conn;
    }
    
    
    public static void createDatabase() {
    	try {
			
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = DBconnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			stmt = conn.createStatement();
			      
		    String sql = "CREATE DATABASE IF NOT EXISTS tubWinterUniversity";
		    
		    stmt.executeUpdate(sql);
		    
		    System.out.println("Database created tubWinterUniversity successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
public static void createTableInDB() {
    	
    	try {
    		
	    	Connection conn = null;
			Statement stmt = null;
	
			try {
				conn = DBconnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			stmt = conn.createStatement();
		
			
			stmt = conn.createStatement();
	        
	        String sql = "CREATE TABLE IF NOT EXISTS students " +
	                     "(id INTEGER not NULL, " +
	                     " firstName VARCHAR(255), " + 
	                     " lastName VARCHAR(255), " + 
	                     " birthDate VARCHAR(255), " + 
	                     " address VARCHAR(255), " + 
	                     " city VARCHAR(255), " + 
	                     " zipCode INTEGER, " + 
	                     " country VARCHAR(255), " + 
	                     " PRIMARY KEY ( id ))"; 
	
	        stmt.executeUpdate(sql);
	        System.out.println("Created table students in given database...");
	   
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }


	public static void insertStudentsToTable() {
	
		try {
			
	    	Connection conn = null;
		    PreparedStatement preparedStatement = null;

			try {
				conn = DBconnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	        
			preparedStatement = conn.prepareStatement("INSERT into  students(id, firstName, lastName, birthDate, address, city, zipCode, country) VALUES (?, ?, ?, ? , ?, ?, ?, ?)");
	  
			GenericController<Student> StudentController = InstantiateState.getStudentControllerWithData();

			ArrayList<Student> students = StudentController.getItems();
			
			
			for(Student student : students) {
				
				
				preparedStatement.setInt(1, student.getStudentId());
	            preparedStatement.setString(2, student.getFirstName());
	            preparedStatement.setString(3, student.getLastName());            
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	            String mysqlDateString = formatter.format(student.getBirthDate());
	            preparedStatement.setString(4, mysqlDateString);
	            preparedStatement.setString(5, student.getAddress());
	            preparedStatement.setString(6, student.getCity());
	            preparedStatement.setInt(7, student.getZipCode());
	            preparedStatement.setString(8, student.getCountry());
	            
	            preparedStatement.executeUpdate();
			}
			
           
        
            System.out.println("Inserting data into students table in given database...");
	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static void getStudentsFromDB() {
		
		try {
			
	    	Connection conn = null;
		    ResultSet resultSet = null;
		    Statement statement = null;

			try {
				conn = DBconnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	        
			statement = conn.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from students");
			  
            System.out.println("Reading data from students table in given database...");
            
            
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String birthDate = resultSet.getString("birthDate");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                Integer zipCode = resultSet.getInt("zipCode");
                String country = resultSet.getString("country");
                
                System.out.println("Id: " + id);
                System.out.println("firstName: " + firstName);
                System.out.println("lastName: " + lastName);
                System.out.println("birthDate: " + birthDate);
                System.out.println("address: " + address);
                System.out.println("city: " + city);
                System.out.println("zipCode: " + zipCode);
                System.out.println("country: " + country + "\n");
            }
	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

    
}
