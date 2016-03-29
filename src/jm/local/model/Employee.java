package jm.local.model;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String industry;
	private String workType;
	private String address;
	private String city;
	private String province;
	private String postalCode;
	private String phone;
	private String email;
	private String startDate;
	private String endDate;
	private String workStatus;
	private String systemStatus;
	private String resume;

	public Employee () {
		setId(0);
		setFirstName("");
		setLastName("");
		setIndustry("");
		setWorkType("");
		setAddress("");
		setCity("");
		setProvince("");
		setPostalCode("");
		setPhone("");
		setEmail("");
		setStartDate("");
		setEndDate("");
		setWorkStatus("");
		setSystemStatus("");
		setResume("");
	}
	
	public Employee (int id, String firstName, String lastName, String industry, String workType, String address, 
			String city, String province, String postalCode, String phone, String email, String startDate, 
			String endDate, String workStatus, String systemStatus, String resume) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setIndustry(industry);
		setWorkType(workType);
		setAddress(address);
		setCity(city);
		setProvince(province);
		setPostalCode(postalCode);
		setPhone(phone);
		setEmail(email);
		setStartDate(startDate);
		setEndDate(endDate);
		setWorkStatus(workStatus);
		setSystemStatus(systemStatus);
		setResume(resume);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getSystemStatus() {
		return systemStatus;
	}

	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
}
