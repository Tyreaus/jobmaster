package jm.local.view;


import jm.local.Main;
import jm.local.data.ClientDataConnector;
import jm.local.data.EmployeeDataConnector;
import jm.local.model.Client;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClientController {
	@FXML
	private TableView<Client> clientTable;
	@FXML
	private TableColumn<Client, String> companyColumn;
	@FXML
	private TableColumn<Client, String> contactColumn;
	@FXML
	private TableColumn<Client, String> addressColumn;
	@FXML
	private TableColumn<Client, String> cityColumn;
	@FXML
	private TableColumn<Client, String> provinceColumn;
	@FXML
	private TableColumn<Client, String> postalCodeColumn;
	@FXML
	private TableColumn<Client, String> phoneColumn;
	@FXML
	private TableColumn<Client, String> emailColumn;
	@FXML
	private TableColumn<Client, String> startDateColumn;
	@FXML
	private TableColumn<Client, String> enddateColumn;
	@FXML
	private TableColumn<Client, String> industryColumn;
	@FXML
	private TableColumn<Client, String> systemStatusColumn;
	@FXML
	private TableColumn<Client, String> notesColumn;

	@FXML
	private ComboBox<String> industryFilterComboBox;
	@FXML
	private ComboBox<String> categoryFilterComboBox;
	@FXML
	private ComboBox<String> systemStatusFilterComboBox;
	@FXML
	private ComboBox<String> workStatusFilterComboBox;
	

	private ObservableList<Client> clientData;
	private ObservableList<String> industryFilterData;
	private ObservableList<String> categoryFilterData;
	private ObservableList<String> systemStatusFilterData;
	private ObservableList<String> workStatusFilterData;
	
	private List<String> columnNames = null;
	private List<Integer> filterCriteria = null;
	

 

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public ClientController() {

	}

	public void getAllEmployeeData() throws SQLException {
		ClientDataConnector clientConnector = new ClientDataConnector();
		
		this.columnNames = clientConnector.getColumnNames();		

		this.clientData = clientConnector.getAllClientData();
	}
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 * 
	 * @throws SQLException
	 */
	@FXML
	private void initialize() throws SQLException {
		
		filterCriteria = new ArrayList<>(4);
		filterCriteria.add(0, 0);
		filterCriteria.add(1, 0);
		filterCriteria.add(2, 0);
		filterCriteria.add(3, 0);

		getComboBoxFilterData();
		setIndustryFilterComboBox();
		setCategoryFilterComboBox();
		setSystemStatusFilterComboBox();
		setWorkStatusFilterComboBox();
		getAllEmployeeData();
		setColumnNames();
		
		// Initialize the person table with the two columns.
		this.companyColumn.setCellValueFactory(cellData -> cellData.getValue().companyProperty());
		this.contactColumn.setCellValueFactory(cellData -> cellData.getValue().contactProperty());
		this.addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
		this.cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		this.provinceColumn.setCellValueFactory(cellData -> cellData.getValue().provinceProperty());
		this.postalCodeColumn.setCellValueFactory(cellData -> cellData.getValue().postalCodeProperty());
		this.phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
		this.emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		this.startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
		this.enddateColumn.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());
		this.industryColumn.setCellValueFactory(cellData -> cellData.getValue().industryProperty());
		this.systemStatusColumn.setCellValueFactory(cellData -> cellData.getValue().systemStatusProperty());
		this.notesColumn.setCellValueFactory(cellData -> cellData.getValue().notesProperty());		

		/*Alert alert = new Alert(AlertType.WARNING);
		
		alert.setContentText(Integer.toString(this.industryFilterData.size()));
		alert.showAndWait();*/
		
		this.industryFilterComboBox.setItems(this.industryFilterData);
		this.categoryFilterComboBox.setItems(this.categoryFilterData);
		this.systemStatusFilterComboBox.setItems(this.systemStatusFilterData);
		this.workStatusFilterComboBox.setItems(this.workStatusFilterData);
		
		this.clientTable.setItems(this.clientData);
		
	}

	
	


	public boolean showClientEditDialog(Client client) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/EmployeeEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Employee");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// dialogStage.initOwner(main.getPrimaryStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the employee into the controller.
			ClientEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setClient(client);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 * 
	 * @param person
	 *            the person or null
	 */

	/*private void showEmployeeDetails(Employee employee) {
		if (employee != null) {
			// Fill the labels with info from the person object.
			idField.setText(Integer.toString(employee.getId()));
			firstNameField.setText(employee.getFirstName());
			lastNameField.setText(employee.getLastName());
			industryField.setText(employee.getIndustry());
			workTypeField.setText(employee.getWorkType());
			addressField.setText(employee.getAddress());
		} else {
			// Person is null, remove all the text.
			idField.setText("");
			firstNameField.setText("");
			lastNameField.setText("");
			industryField.setText("");
			workTypeField.setText("");
			addressField.setText("");
		}
	}*/

	@FXML
	private void handleDeleteClient() {
		int selectedIndex = this.clientTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			this.clientTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 * 
	 * @throws SQLException
	 */
	@FXML
	private void handleNewClient() throws SQLException {
		Client tempClient = new Client();
		boolean okClicked = showClientEditDialog(tempClient);
		if (okClicked) {
			this.clientData.add(tempClient);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditEmployee() {
		Client selectedClient = this.clientTable.getSelectionModel().getSelectedItem();
		if (selectedClient != null) {
			boolean okClicked = showClientEditDialog(selectedClient);
			if (okClicked) {
				//showEmployeeDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}
	

	private void setColumnNames() {				
		for (int i = 1; i < this.columnNames.size(); i++) {
			this.clientTable.getColumns().get(i - 1).setText(this.columnNames.get(i));			
		}
	}

	@FXML
	private void handleIndustryFilterComboBox() {
		this.industryFilterComboBox.setOnAction((event) -> {
		    Integer selectedIndustry = this.industryFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
		    this.filterCriteria.set(0, selectedIndustry);		    
	    	getFilteredClientData();	   
		    
		});
		
	}
	
	@FXML
	private void handleCategoryFilterComboBox() {
		this.categoryFilterComboBox.setOnAction((event) -> {
		    Integer selectedCategory = this.categoryFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
		    this.filterCriteria.set(1, selectedCategory);		    
		    getFilteredClientData();
		    
		});
	}
	
	@FXML
	private void handleSystemStatusFilterComboBox() {
		this.systemStatusFilterComboBox.setOnAction((event) -> {
		    Integer selectedSystemStatus = this.systemStatusFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
		    this.filterCriteria.set(2, selectedSystemStatus);		    
		    getFilteredClientData();
		});
	}
	
	@FXML
	private void handleWorkStatusFilterComboBox() {
		this.workStatusFilterComboBox.setOnAction((event) -> {
		    Integer selectedWorkStatus = this.workStatusFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
		    this.filterCriteria.set(3, selectedWorkStatus);		    
		    getFilteredClientData();
		});
	}
	
	
	private void getFilteredClientData() {

		ClientDataConnector clientConnector = new ClientDataConnector();
		
		this.columnNames = clientConnector.getColumnNames();		

		//this.employeeData = employeeConnector.getFilteredEmployeeData(1,1,1,1);
		this.clientData = clientConnector.getFilteredClientData(this.filterCriteria.get(0), this.filterCriteria.get(1), this.filterCriteria.get(2), this.filterCriteria.get(3));
		this.clientTable.setItems(this.clientData);
	}
	
	private void getComboBoxFilterData() {
		
		EmployeeDataConnector clientConnector = new EmployeeDataConnector();
		
		this.industryFilterData = clientConnector.getIndustries();
		this.categoryFilterData = clientConnector.getCategories();
		this.systemStatusFilterData = clientConnector.getSystemStatuses();
		this.workStatusFilterData = clientConnector.getWorkStatuses();
		
	}
	private void setIndustryFilterComboBox() {
		industryFilterComboBox.setCellFactory((comboBox) -> {
		    return new ListCell<String>() {
		        @Override
		        protected void updateItem(String item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item);
		            }
		        }
		    };
		});
		
	}
	
	private void setCategoryFilterComboBox() {
		categoryFilterComboBox.setCellFactory((comboBox) -> {
		    return new ListCell<String>() {
		        @Override
		        protected void updateItem(String item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item);
		            }
		        }
		    };
		});
		
	}
	
	private void setSystemStatusFilterComboBox() {
		systemStatusFilterComboBox.setCellFactory((comboBox) -> {
		    return new ListCell<String>() {
		        @Override
		        protected void updateItem(String item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item);
		            }
		        }
		    };
		});
	}
	
	private void setWorkStatusFilterComboBox() {
		workStatusFilterComboBox.setCellFactory((comboBox) -> {
		    return new ListCell<String>() {
		        @Override
		        protected void updateItem(String item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                setText(item);
		            }
		        }
		    };
		});
	}
}