package com.graded.jdbc;

import java.sql.*;

public class EmployeeOperations {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/gl?useSSL=false";

	static final String USER = "root";
	static final String PASS = "Nisha@11";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			// Create table employee
			String sql1 = "CREATE TABLE employee ( " + "Id INT PRIMARY KEY, " + "Name VARCHAR(50) NOT NULL, "
					+ "Email_Id VARCHAR(50) NOT NULL, " + "Phone_Number VARCHAR(20))";
			stmt.executeUpdate(sql1);

			System.out.println("Table 'employee' created successfully.");

			// a. Insert 5 records
			String sql = "INSERT INTO employee (Id,Name, Email_Id, Phone_Number) VALUES ";
			sql += "(1,'John', 'john@example.com', '1234567890'), ";
			sql += "(2,'Alice', 'alice@example.com', '9876543210'), ";
			sql += "(3,'Bob', 'bob@example.com', '9998887776'), ";
			sql += "(4,'Emma', 'emma@example.com', '8765432109'), ";
			sql += "(5,'Sam', 'sam@example.com', '7890123456')";
			stmt.executeUpdate(sql);

			System.out.println("Five records inserted successfully.");

			// b. Modify Email_Id column to varchar(30) NOT NULL
			sql = "ALTER TABLE employee MODIFY COLUMN Email_Id VARCHAR(30) NOT NULL";
			stmt.executeUpdate(sql);

			System.out.println("Coulmn 'Email_Id' modified successfully.");

			// c. Insert 2 records and check
			sql = "INSERT INTO employee (Id,Name, Email_Id, Phone_Number) VALUES ";
			sql += "(6,'David', 'david@example.com', '9876543210'), ";
			sql += "(7,'Sophia', 'sophia@example.com', '9876543210')";
			stmt.executeUpdate(sql);

			System.out.println("Two records inserted successfully.");

			// d. Update the name of employee Id 3 to Karthik and phone number to 1234567890
			sql = "UPDATE employee SET Name = 'Karthik', Phone_Number = '1234567890' WHERE Id = 3";
			stmt.executeUpdate(sql);

			System.out.println("Update done successfully.");

			// e. Delete employee records 3 and 4
			sql = "DELETE FROM employee WHERE Id IN (3, 4)";
			stmt.executeUpdate(sql);

			System.out.println("Records 3 and 4 deleted successfully.");

			// f. Remove all records from the table employee
			sql = "DELETE FROM employee";
			stmt.executeUpdate(sql);

			System.out.println("All records deleted successfully.");

			System.out.println("Operations completed successfully.");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
