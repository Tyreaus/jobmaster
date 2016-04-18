package jm.local.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Job {
	private final IntegerProperty id;
	private final StringProperty company;
	private final StringProperty description;
	private final StringProperty address;
	private final StringProperty city;
	private final StringProperty province;
	private final StringProperty postalCode;
	private final StringProperty startDate;
	private final StringProperty endDate;
	private final StringProperty industry;
	private final StringProperty systemStatus;
	private final StringProperty markup;
	private final StringProperty notes;
	
	

	public Job () {
		this(0, null, null, null, null, null, null, null, null, null, null, null, null);		
	}
	
	public Job(int id, int clientId) {
		this(id, null, null, null, null, null, null, null, null, null, null, null, null);
		
	}
	
	public Job (int id, String company, String description, String address, 
			String city, String province, String postalCode, String startDate, 
			String endDate, String industry, String systemStatus, String markup, String notes) {
		
		this.id = new SimpleIntegerProperty(id);
		this.company = new SimpleStringProperty(company);
		this.description = new SimpleStringProperty(description);
		this.address = new SimpleStringProperty(address);
		this.city = new SimpleStringProperty(city);
		this.province = new SimpleStringProperty(province);
		this.postalCode = new SimpleStringProperty(postalCode);
		this.startDate = new SimpleStringProperty(startDate);
		this.endDate = new SimpleStringProperty(endDate);
		this.industry = new SimpleStringProperty(industry);
		this.systemStatus = new SimpleStringProperty(systemStatus);
		this.markup = new SimpleStringProperty(markup);
		this.notes = new SimpleStringProperty(notes);
		
        
	}

	
// Get Methods ***********************************************************************************
	public int getId() {
		return id.get();
	}

	public String getCompany() {
		return company.get();
	}

	public String getDescription() {
		return description.get();
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

	public String getStartDate() {
		return startDate.get();
	}

	public String getEndDate() {
		return endDate.get();
	}
	
	public String getIndustry() {
		return industry.get();
	}
	
	public String getSystemStatus() {
		return systemStatus.get();
	}

	public String getMarkup() {
		return markup.get();
	}
	
	public String getNotes() {
		return notes.get();
	}

	
// Set Methods ************************************************************************************
	
	public void setId(int id) {
		this.id.set(id);
	}

	public void setCompany(String company) {
		this.company.set(company);
	}

	public void setDescription(String description) {
		this.description.set(description);
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

	public void setStartDate(String startDate) {
		this.startDate.set(startDate);
	}

	public void setEndDate(String endDate) {
		this.endDate.set(endDate);
	}
	
	public void setIndustry(String industry) {
		this.industry.set(industry);
	}
	
	public void setSystemStatus(String systemStatus) {
		this.systemStatus.set(systemStatus);
	}

	public void setMarkup(String markup) {
		this.markup.set(markup);
	}
	
	public void setNotes(String notes) {
		this.notes.set(notes);
	}
// Property Methods***************************************************************************
	
	public IntegerProperty idProperty() {
		return id;
	}
	
	public StringProperty companyProperty() {
		return company;
	}
	
	public StringProperty descriptionProperty() {
		return description;
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

	public StringProperty startDateProperty() {
		return startDate;
	}

	public StringProperty endDateProperty() {
		return endDate;
	}
	
	public StringProperty industryProperty() {
		return industry;
	}
	
	public StringProperty systemStatusProperty() {
		return systemStatus;
	}

	public StringProperty markupProperty() {
		return markup;
	}
	
	public StringProperty notesProperty() {
		return notes;
	}

}
