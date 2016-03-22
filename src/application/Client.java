package application;

public class Client {
	private int id;
	private String company;
	private String contact;
	private String address;
	private String city;
	private String province;
	private String postalCode;
	private String phone;
	private String email;
	private String startDate;
	private String endDate;
	private String industry;
	private String systemStatus;
	private String notes;

	public Client () {
		setId(0);
		setCompany("");
		setContact("");
		setAddress("");
		setCity("");
		setProvince("");
		setPostalCode("");
		setPhone("");
		setEmail("");
		setStartDate("");
		setEndDate("");
		setIndustry("");
		setSystemStatus("");
		setNotes("");
	}
	
	public Client (int id, String company, String contact, String workType, String address, 
			String city, String province, String postalCode, String phone, String email, String startDate, 
			String endDate, String industry, String systemStatus, String notes) {
		setId(id);
		setCompany(company);
		setContact(contact);
		setAddress(address);
		setCity(city);
		setProvince(province);
		setPostalCode(postalCode);
		setPhone(phone);
		setEmail(email);
		setStartDate(startDate);
		setEndDate(endDate);
		setIndustry(industry);
		setSystemStatus(systemStatus);
		setNotes(notes);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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
	
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSystemStatus() {
		return systemStatus;
	}

	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
