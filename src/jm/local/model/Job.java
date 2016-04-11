package jm.local.model;

public class Job {
	private int id;
	private int clientId;
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
		setClientId(0);
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
	
	public Job (int id, int clientId, String description, String address, String city, String province,
			String postalCode, String startDate, String endDate, String markup, String notes) {
		setId(id);
		setClientId(clientId);
		setDescription(description);
		setAddress(address);
		setCity(city);
		setProvince(province);
		setPostalCode(postalCode);
		setStartDate(startDate);
		setEndDate(endDate);
		setMarkup(markup);
		setNotes(notes);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getMarkup() {
		return markup;
	}

	public void setMarkup(String markup) {
		this.markup = markup;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
