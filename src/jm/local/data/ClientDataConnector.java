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
import jm.local.model.Client;

public class ClientDataConnector {
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
	

	public ObservableList<Client> getAllClientData() {
		ObservableList<Client> clientData = null;
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			CallableStatement cs = conn.prepareCall("{call getAllClientData}");
			ResultSet rs = cs.executeQuery();

			setColumnNames(rs.getMetaData());

			clientData = fillClientRecords(rs);

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
		return clientData;

	}

	private ObservableList<Client> fillClientRecords(ResultSet rs) throws SQLException {
		ObservableList<Client> clientData = FXCollections.observableArrayList();

		/********************************
		 * Data added to ObservableList *
		 ********************************/
		rs.beforeFirst();
		while (rs.next()) {
			// Iterate Row
			Client client = new Client();

			client.setId(rs.getInt("id"));
			client.setCompany(rs.getString("Company"));
			client.setContact(rs.getString("Contact"));			
			client.setAddress(rs.getString("Address"));
			client.setCity(rs.getString("City"));
			client.setProvince(rs.getString("Province"));
			client.setPostalCode(rs.getString("Postal_Code"));
			client.setPhone(rs.getString("Phone"));
			client.setEmail(rs.getString("Email"));
			client.setStartDate(rs.getString("Start_Date"));
			client.setEndDate(rs.getString("End_Date"));
			client.setIndustry(rs.getString("Industry"));
			client.setSystemStatus(rs.getString("System_Status"));
			client.setNotes(rs.getString("Notes"));

			clientData.add(client);

		}

		return clientData;
	}

	private void setColumnNames(ResultSetMetaData rsMetaData) throws SQLException {
		for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
			this.columnNames.add(rsMetaData.getColumnName(i + 1));
			//System.out.println(this.columnNames.get(i));
		}
	}

	public List<String> getColumnNames() {
		return this.columnNames;
	}

	public ObservableList<Client> getFilteredClientData(Integer industryFilter, Integer categoryFilter, Integer systemStatusFilter, Integer workStatusFilter) {
		ObservableList<Client> clientData = null;
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			CallableStatement cs = conn.prepareCall("{call getFilteredClientData(?,?,?,?)}");
			cs.setInt(1, industryFilter);
			cs.setInt(2, categoryFilter);
			cs.setInt(3, systemStatusFilter);
			cs.setInt(4, workStatusFilter);
			ResultSet rs = cs.executeQuery();

			
			setColumnNames(rs.getMetaData());
			//showAllRecords(rs);
			clientData = fillClientRecords(rs);

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
		return clientData;
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
