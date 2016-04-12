package jm.local.view;

import jm.local.Main;
import jm.local.data.EmployeeDataConnector;
import jm.local.model.Employee;

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

public class EmployeeController {
	@FXML
	private TableView<Employee> employeeTable;
	@FXML
	private TableColumn<Employee, String> firstNameColumn;
	@FXML
	private TableColumn<Employee, String> lastNameColumn;
	@FXML
	private TableColumn<Employee, String> industryColumn;
	@FXML
	private TableColumn<Employee, String> workTypeColumn;
	@FXML
	private TableColumn<Employee, String> addressColumn;
	@FXML
	private TableColumn<Employee, String> cityColumn;
	@FXML
	private TableColumn<Employee, String> provinceColumn;
	@FXML
	private TableColumn<Employee, String> postalCodeColumn;
	@FXML
	private TableColumn<Employee, String> phoneColumn;
	@FXML
	private TableColumn<Employee, String> emailColumn;
	@FXML
	private TableColumn<Employee, String> startDateColumn;
	@FXML
	private TableColumn<Employee, String> enddateColumn;
	@FXML
	private TableColumn<Employee, String> workStatusColumn;
	@FXML
	private TableColumn<Employee, String> systemStatusColumn;
	@FXML
	private TableColumn<Employee, String> resumeColumn;
	@FXML
	private TableColumn<Employee, String> notesColumn;

	@FXML
	private ComboBox<String> industryFilterComboBox;
	@FXML
	private ComboBox<String> categoryFilterComboBox;
	@FXML
	private ComboBox<String> systemStatusFilterComboBox;
	@FXML
	private ComboBox<String> workStatusFilterComboBox;
	

	private ObservableList<Employee> employeeData;
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
	public EmployeeController() {

	}

	public void getAllEmployeeData() throws SQLException {
		EmployeeDataConnector employeeConnector = new EmployeeDataConnector();
		
		this.columnNames = employeeConnector.getEmployeeColumnNames();		

		this.employeeData = employeeConnector.getAllEmployeeData();
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
		this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		this.industryColumn.setCellValueFactory(cellData -> cellData.getValue().industryProperty());
		this.workTypeColumn.setCellValueFactory(cellData -> cellData.getValue().workTypeProperty());
		this.addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
		this.cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		this.provinceColumn.setCellValueFactory(cellData -> cellData.getValue().provinceProperty());
		this.postalCodeColumn.setCellValueFactory(cellData -> cellData.getValue().postalCodeProperty());
		this.phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
		this.emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		this.startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
		this.enddateColumn.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());
		this.workStatusColumn.setCellValueFactory(cellData -> cellData.getValue().workStatusProperty());
		this.systemStatusColumn.setCellValueFactory(cellData -> cellData.getValue().systemStatusProperty());
		this.resumeColumn.setCellValueFactory(cellData -> cellData.getValue().resumeProperty());
		this.notesColumn.setCellValueFactory(cellData -> cellData.getValue().notesProperty());		

		/*Alert alert = new Alert(AlertType.WARNING);
		
		alert.setContentText(Integer.toString(this.industryFilterData.size()));
		alert.showAndWait();*/
		
		this.industryFilterComboBox.setItems(this.industryFilterData);
		this.categoryFilterComboBox.setItems(this.categoryFilterData);
		this.systemStatusFilterComboBox.setItems(this.systemStatusFilterData);
		this.workStatusFilterComboBox.setItems(this.workStatusFilterData);
		
		this.employeeTable.setItems(this.employeeData);
		
	}

	
	


	public boolean showEmployeeEditDialog(Employee employee) {
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
			EmployeeEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setEmployee(employee);

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
	private void handleDeleteEmployee() {
		int selectedIndex = this.employeeTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			this.employeeTable.getItems().remove(selectedIndex);
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
	private void handleNewEmployee() throws SQLException {
		Employee tempPerson = new Employee();
		boolean okClicked = showEmployeeEditDialog(tempPerson);
		if (okClicked) {
			this.employeeData.add(tempPerson);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditEmployee() {
		Employee selectedPerson = this.employeeTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = showEmployeeEditDialog(selectedPerson);
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
			this.employeeTable.getColumns().get(i - 1).setText(this.columnNames.get(i));			
		}
	}

	@FXML
	private void handleIndustryFilterComboBox() {
		this.industryFilterComboBox.setOnAction((event) -> {
		    Integer selectedIndustry = this.industryFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
		    this.filterCriteria.set(0, selectedIndustry);		    
	    	getFilteredEmployeeData();	   
		    
		});
		
	}
	
	@FXML
	private void handleCategoryFilterComboBox() {
		this.categoryFilterComboBox.setOnAction((event) -> {
		    Integer selectedCategory = this.categoryFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
		    this.filterCriteria.set(1, selectedCategory);		    
		    getFilteredEmployeeData();
		    
		});
	}
	
	@FXML
	private void handleSystemStatusFilterComboBox() {
		this.systemStatusFilterComboBox.setOnAction((event) -> {
		    Integer selectedSystemStatus = this.systemStatusFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
		    this.filterCriteria.set(2, selectedSystemStatus);		    
		    getFilteredEmployeeData();
		});
	}
	
	@FXML
	private void handleWorkStatusFilterComboBox() {
		this.workStatusFilterComboBox.setOnAction((event) -> {
		    Integer selectedWorkStatus = this.workStatusFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
		    this.filterCriteria.set(3, selectedWorkStatus);		    
		    getFilteredEmployeeData();
		});
	}
	
	
	private void getFilteredEmployeeData() {

		EmployeeDataConnector employeeConnector = new EmployeeDataConnector();
		
		this.columnNames = employeeConnector.getEmployeeColumnNames();		

		//this.employeeData = employeeConnector.getFilteredEmployeeData(1,1,1,1);
		this.employeeData = employeeConnector.getFilteredEmployeeData(this.filterCriteria.get(0), this.filterCriteria.get(1), this.filterCriteria.get(2), this.filterCriteria.get(3));
		this.employeeTable.setItems(this.employeeData);
	}
	
	private void getComboBoxFilterData() {
		
		EmployeeDataConnector employeeConnector = new EmployeeDataConnector();
		
		this.industryFilterData = employeeConnector.getIndustries();
		this.categoryFilterData = employeeConnector.getCategories();
		this.systemStatusFilterData = employeeConnector.getSystemStatuses();
		this.workStatusFilterData = employeeConnector.getWorkStatuses();
		
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