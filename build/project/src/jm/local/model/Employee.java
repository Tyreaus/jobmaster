package jm.local.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
	private final IntegerProperty id;
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty industry;
	private final StringProperty workType;
	private final StringProperty address;
	private final StringProperty city;
	private final StringProperty province;
	private final StringProperty postalCode;
	private final StringProperty phone;
	private final StringProperty email;
	private final StringProperty startDate;
	private final StringProperty endDate;
	private final StringProperty workStatus;
	private final StringProperty systemStatus;
	private final StringProperty resume;
	private final StringProperty notes;
	
	

	public Employee () {
		this(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);		
	}
	
	public Employee(int id, String firstName, String lastName) {
		this(id, firstName, lastName, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
	}
	
	public Employee (int id, String firstName, String lastName, String industry, String workType, String address, 
			String city, String province, String postalCode, String phone, String email, String startDate, 
			String endDate, String workStatus, String systemStatus, String resume, String notes) {
		
		this.id = new SimpleIntegerProperty(id);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.industry = new SimpleStringProperty(industry);
		this.workType = new SimpleStringProperty(workType);
		this.address = new SimpleStringProperty(address);
		this.city = new SimpleStringProperty(city);
		this.province = new SimpleStringProperty(province);
		this.postalCode = new SimpleStringProperty(postalCode);
		this.phone = new SimpleStringProperty(phone);
		this.email = new SimpleStringProperty(email);
		this.startDate = new SimpleStringProperty(startDate);
		this.endDate = new SimpleStringProperty(endDate);
		this.workStatus = new SimpleStringProperty(workStatus);
		this.systemStatus = new SimpleStringProperty(systemStatus);
		this.resume = new SimpleStringProperty(resume);
		this.notes = new SimpleStringProperty(notes);
		
        
	}

	
// Get Methods ***********************************************************************************
	public int getId() {
		return id.get();
	}

	public String getFirstName() {
		return firstName.get();
	}

	public String getLastName() {
		return lastName.get();
	}

	public String getIndustry() {
		return industry.get();
	}

	public String getWorkType() {
		return workType.get();
	}

	public String getAddress() {
		return address.get();
	}

	public String getCity() {
		return city.get();
	}

	public String getProvince() {
		return province.get();
	}

	public String getPostalCode() {
		return postalCode.get();
	}

	public String getPhone() {
		return phone.get();
	}

	public String getEmail() {
		return email.get();
	}

	public String getStartDate() {
		return startDate.get();
	}

	public String getEndDate() {
		return endDate.get();
	}

	public String getWorkStatus() {
		return workStatus.get();
	}

	public String getSystemStatus() {
		return systemStatus.get();
	}

	public String getResume() {
		return resume.get();
	}
	
	public String getNotes() {
		return notes.get();
	}

	
// Set Methods ************************************************************************************
	
	public void setId(int id) {
		this.id.set(id);
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public void setIndustry(String industry) {
		this.industry.set(industry);
	}

	public void setWorkType(String workType) {
		this.workType.set(workType);
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public void setProvince(String province) {
		this.province.set(province);
	}

	public void setPostalCode(String postalCode) {
		this.postalCode.set(postalCode);
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public void setStartDate(String startDate) {
		this.startDate.set(startDate);
	}

	public void setEndDate(String endDate) {
		this.endDate.set(endDate);
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus.set(workStatus);
	}

	public void setSystemStatus(String systemStatus) {
		this.systemStatus.set(systemStatus);
	}

	public void setResume(String resume) {
		this.resume.set(resume);
	}
	
	public void setNotes(String notes) {
		this.notes.set(notes);
	}
// Property Methods***************************************************************************
	
	public IntegerProperty idProperty() {
		return id;
	}
	
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public StringProperty lastNameProperty() {
		return lastName;
	}

	public StringProperty industryProperty() {
		return industry;
	}

	public StringProperty workTypeProperty() {
		return workType;
	}

	public StringProperty addressProperty() {
		return address;
	}

	public StringProperty cityProperty() {
		return city;
	}

	public StringProperty provinceProperty() {
		return province;
	}

	public StringProperty postalCodeProperty() {
		return postalCode;
	}

	public StringProperty phoneProperty() {
		return phone;
	}

	public StringProperty emailProperty() {
		return email;
	}

	public StringProperty startDateProperty() {
		return startDate;
	}

	public StringProperty endDateProperty() {
		return endDate;
	}

	public StringProperty workStatusProperty() {
		return workStatus;
	}

	public StringProperty systemStatusProperty() {
		return systemStatus;
	}

	public StringProperty resumeProperty() {
		return resume;
	}
	
	public StringProperty notesProperty() {
		return notes;
	}

}
