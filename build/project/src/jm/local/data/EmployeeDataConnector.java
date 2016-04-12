package jm.local.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jm.local.model.Employee;

public class EmployeeDataConnector {
	private List<String> columnNames = new ArrayList<>();

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://24.86.120.113/admin_DataMaster";

	// Database credentials
	static final String USER = "rmoteJMuser";
	static final String PASS = "HCmXjHh5GG5Jvqd2";
	
	
	public ObservableList<String> getIndustries() {
		ObservableList<String> industries = FXCollections.observableArrayList();
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			CallableStatement cs = conn.prepareCall("{call getIndustries}");
			ResultSet rs = cs.executeQuery();

			while(rs.next())
			{
				industries.add(rs.getString("industry_type"));
			}
			

			rs.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		
		return industries;
	}
	
	public ObservableList<String> getCategories() {
		ObservableList<String> categories = FXCollections.observableArrayList();;
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			CallableStatement cs = conn.prepareCall("{call getCategories}");
			ResultSet rs = cs.executeQuery();

			while(rs.next())
			{
				categories.add(rs.getString("category_type"));
			}
			

			rs.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		
		
		return categories;
	}
	
	public ObservableList<String> getSystemStatuses() {
		ObservableList<String> systemStatuses = FXCollections.observableArrayList();;
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			CallableStatement cs = conn.prepareCall("{call getSystemStatuses}");
			ResultSet rs = cs.executeQuery();
			
			while(rs.next())
			{
				systemStatuses.add(rs.getString("Status_Type"));
			}
			

			rs.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		
		
		return systemStatuses;
	}
	
	public ObservableList<String> getWorkStatuses() {
		ObservableList<String> workStatuses = FXCollections.observableArrayList();;
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			CallableStatement cs = conn.prepareCall("{call getWorkStatuses}");
			ResultSet rs = cs.executeQuery();

			while(rs.next())
			{
				workStatuses.add(rs.getString("Work_Status_Type"));
			}
			

			rs.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		
		
		return workStatuses;
	}
	

	public ObservableList<Employee> getAllEmployeeData() {
		ObservableList<Employee> employeeData = null;
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			CallableStatement cs = conn.prepareCall("{call getAllEmployeeData}");
			ResultSet rs = cs.executeQuery();

			setColumnNames(rs.getMetaData());

			employeeData = fillEmployeeRecords(rs);

			rs.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		return employeeData;

	}

	private ObservableList<Employee> fillEmployeeRecords(ResultSet rs) throws SQLException {
		ObservableList<Employee> employeeData = FXCollections.observableArrayList();

		/********************************
		 * Data added to ObservableList *
		 ********************************/
		rs.beforeFirst();
		while (rs.next()) {
			// Iterate Row
			Employee employee = new Employee();

			employee.setId(rs.getInt("id"));
			employee.setFirstName(rs.getString("First_Name"));
			employee.setLastName(rs.getString("Last_Name"));
			employee.setIndustry(rs.getString("Industry"));
			employee.setWorkType(rs.getString("Work_Type"));
			employee.setAddress(rs.getString("Address"));
			employee.setCity(rs.getString("City"));
			employee.setProvince(rs.getString("Province"));
			employee.setPostalCode(rs.getString("Postal_Code"));
			employee.setPhone(rs.getString("Phone"));
			employee.setEmail(rs.getString("Email"));
			employee.setStartDate(rs.getString("Start_Date"));
			employee.setEndDate(rs.getString("End_Date"));
			employee.setWorkStatus(rs.getString("Work_Status"));
			employee.setSystemStatus(rs.getString("System_Status"));
			employee.setResume(rs.getString("Resume"));
			employee.setNotes(rs.getString("Notes"));

			employeeData.add(employee);

		}

		return employeeData;
	}

	private void setColumnNames(ResultSetMetaData rsMetaData) throws SQLException {
		for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
			this.columnNames.add(rsMetaData.getColumnName(i + 1));
			//System.out.println(this.columnNames.get(i));
		}
	}

	public List<String> getEmployeeColumnNames() {
		return this.columnNames;
	}

	public ObservableList<Employee> getFilteredEmployeeData(Integer industryFilter, Integer categoryFilter, Integer systemStatusFilter, Integer workStatusFilter) {
		ObservableList<Employee> employeeData = null;
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			CallableStatement cs = conn.prepareCall("{call getFilteredEmployeeData(?,?,?,?)}");
			cs.setInt(1, industryFilter);
			cs.setInt(2, categoryFilter);
			cs.setInt(3, systemStatusFilter);
			cs.setInt(4, workStatusFilter);
			ResultSet rs = cs.executeQuery();

			
			setColumnNames(rs.getMetaData());
			//showAllRecords(rs);
			employeeData = fillEmployeeRecords(rs);

			rs.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try

		} // end try
		return employeeData;
	}
	
	private void showAllRecords(ResultSet rs) throws SQLException {
		while (rs.next()) {
		System.out.println(rs.getInt("id") 
				+ ", " + rs.getString("Last_Name") 
				+ ", " + rs.getString("Industry") 
				+ ", " + rs.getString("Work_Type")
				 + ", " + rs.getString("Address")
				 + ", " + rs.getString("City")
				 + ", " + rs.getString("Province")
				 + ", " + rs.getString("Postal_Code")
				 + ", " + rs.getString("Phone")
				 + ", " + rs.getString("Email")
				 + ", " + rs.getString("Start_Date")
				 + ", " + rs.getString("End_Date")
				 + ", " + rs.getString("Work_Status")
				 + ", " + rs.getString("System_Status")
				 + ", " + rs.getString("Resume")
				 + ", " + rs.getString("Notes"));
		}

	}

}
