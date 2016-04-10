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

	

}
