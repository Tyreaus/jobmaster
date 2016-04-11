package jm.local.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JobEmployee {
	private final IntegerProperty id;
	private final IntegerProperty jobId;
	private final IntegerProperty employeeId;
	private final StringProperty jobType;
	private final DoubleProperty salaryWage;
	private final StringProperty startDate;
	private final StringProperty endDate;
	private final DoubleProperty perDiem;
	private final StringProperty notes;
	
	

	public JobEmployee () {
		this.id = null;
		this.jobId = null;
		this.employeeId = null;
		this.jobType = null;
		this.salaryWage = null;
		this.startDate = null;
		this.endDate = null;
		this.perDiem = null;
		this.notes = null;
	}
	
	public JobEmployee (int id, int jobId, int employeeId) {
		this.id = new SimpleIntegerProperty(id);
		this.jobId = new SimpleIntegerProperty(jobId);
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.jobType = null;
		this.salaryWage = null;
		this.startDate = null;
		this.endDate = null;
		this.perDiem = null;
		this.notes = null;
	}
	
	public JobEmployee (int id, int jobId, int employeeId, String jobType, 
			double salaryWage, String startDate, String endDate, double perDiem, String notes) {
		
		this.id = new SimpleIntegerProperty(id);
		this.jobId = new SimpleIntegerProperty(jobId);
		this.employeeId = new SimpleIntegerProperty(employeeId);
		this.jobType = new SimpleStringProperty(jobType);
		this.salaryWage = new SimpleDoubleProperty(salaryWage);
		this.startDate = new SimpleStringProperty(startDate);
		this.endDate = new SimpleStringProperty(endDate);
		this.perDiem = new SimpleDoubleProperty(perDiem);
		this.notes = new SimpleStringProperty(notes);
		
        
	}

	
// Get Methods ***********************************************************************************
	public int getId() {
		return id.get();
	}

	public int getJobId() {
		return jobId.get();
	}

	public int getEmployeeId() {
		return employeeId.get();
	}

	public String getJobType() {
		return jobType.get();
	}

	public double getSalaryWage() {
		return salaryWage.get();
	}

	public String getStartDate() {
		return startDate.get();
	}

	public String getEndDate() {
		return endDate.get();
	}

	public double getPerDiem() {
		return perDiem.get();
	}
	
	public String getNotes() {
		return notes.get();
	}

	
// Set Methods ************************************************************************************
	
	public void setId(int id) {
		this.id.set(id);
	}

	public void setJobId(int jobId) {
		this.jobId.set(jobId);
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId.set(employeeId);
	}

	public void setJobType(String jobType) {
		this.jobType.set(jobType);
	}

	public void setSalaryWage(double salaryWage) {
		this.salaryWage.set(salaryWage);
	}

	public void setStartDate(String startDate) {
		this.startDate.set(startDate);
	}

	public void setEndDate(String endDate) {
		this.endDate.set(endDate);
	}

	public void setPerDiem(double perDiem) {
		this.perDiem.set(perDiem);
	}
	
	public void setNotes(String notes) {
		this.notes.set(notes);
	}
// Property Methods***************************************************************************
	
	public IntegerProperty idProperty() {
		return id;
	}
	
	public IntegerProperty jobIdProperty() {
		return jobId;
	}
	
	public IntegerProperty employeeIdProperty() {
		return employeeId;
	}

	public StringProperty jobTypeProperty() {
		return jobType;
	}

	public DoubleProperty salaryWageProperty() {
		return salaryWage;
	}

	public StringProperty startDateProperty() {
		return startDate;
	}

	public StringProperty endDateProperty() {
		return endDate;
	}

	public DoubleProperty perDiemProperty() {
		return perDiem;
	}
	
	public StringProperty notesProperty() {
		return notes;
	}

}