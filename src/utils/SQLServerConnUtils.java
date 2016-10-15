package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConnUtils {
	
	public static Connection getSQLServerConnection() {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
		         "databaseName=QuanLyCongTyTaxi;integratedSecurity=True"; 
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
//	public static void main(String[] args) {  
//		  
//	      Connection con = getSQLServerConnection();  
//	      Statement stmt = null;  
//	      ResultSet rs = null;  
//	  
//	      try {  
//	         // Create and execute an SQL statement that returns some data.  
//	         String SQL = "SELECT TOP 10 * FROM XE";  
//	         stmt = con.createStatement();  
//	         rs = stmt.executeQuery(SQL);  
//	  
//	         // Iterate through the data in the result set and display it.  
//	         while (rs.next()) {  
//	            System.out.println(rs.getString(1) + " | " + rs.getString(2));  
//	         }  
//	      }  
//	  
//	      // Handle any errors that may have occurred.  
//	      catch (Exception e) {  
//	         e.printStackTrace();  
//	      }  
//	      finally {  
//	         if (rs != null) try { rs.close(); } catch(Exception e) {}  
//	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
//	         if (con != null) try { con.close(); } catch(Exception e) {}  
//	      }  
//	   }  
}
