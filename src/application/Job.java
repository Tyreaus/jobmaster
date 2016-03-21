package application;

public class Job {
	private int id;
	private String clientId;
	private String description;
	private String address;
	private String city;
	private String province;
	private String postalCode;
	private String startDate;
	private String endDate;
	private String markup;
	private String notes;

	public Job () {
		setId(0);
		setClientId("");
		setDescription("");
		setAddress("");
		setCity("");
		setProvince("");
		setPostalCode("");
		setStartDate("");
		setEndDate("");
		setMarkup("");
		setNotes("");
	}
	
	public Job (int id, String clientId, String description, String address, String city, String province,
			String postalCode, String startDate, String endDate, String markup, String notes) {
		setId(id);
		setFirstName(clientId);
		setLastName(description);
		setAddress(address);
		setCity(city);
		setProvince(province);
		setPostalCode(postalCode);
		setStartDate(startDate);
		setEndDate(endDate);
		setWorkStatus(markup);
		setSystemStatus(notes);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
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
