package application;

public class JobEmployee {
	private int id;
	private int jobId;
	private int employeeId;
	private String jobType;
	private double salaryWage;
	private String startDate;
	private String endDate;
	private double perDiem;
	private String notes;

	public JobEmployee () {
		setId(0);
		setJobId(0);
		setEmployeeId(0);
		setJobType("");
		setSalaryWage(0);
		setStartDate("");
		setEndDate("");
		setPerDiem(0);
		setNotes("");
	}
	
	public JobEmployee (int id, int jobId, int employeeId, String jobType, double salaryWage, String startDate, 
			String endDate, double perDiem, String notes) {
		setId(id);
		setJobId(jobId);
		setEmployeeId(employeeId);
		setJobType(jobType);
		setSalaryWage(salaryWage);
		setStartDate(startDate);
		setEndDate(endDate);
		setPerDiem(perDiem);
		setNotes(notes);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int setEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public double getSalaryWage() {
		return salaryWage;
	}

	public void setSalaryWage(double salaryWage) {
		this.salaryWage = salaryWage;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public double getPerDiem() {
		return perDiem;
	}

	public void setPerDiem(double perDiem) {
		this.perDiem = perDiem;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
