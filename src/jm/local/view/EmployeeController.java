package jm.local.view;

import jm.local.Main;
import jm.local.data.EmployeeDataConnector;
import jm.local.model.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

	

	private ObservableList<Employee> employeeData;
	
	private List<String> columnNames;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public EmployeeController() {

	}

	public void getAllEmployeeData() throws SQLException {
		EmployeeDataConnector employeeConnector = new EmployeeDataConnector();
		
		columnNames = employeeConnector.getEmployeeColumnNames();		

		employeeData = employeeConnector.getAllEmployeeData();
	}
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 * 
	 * @throws SQLException
	 */
	@FXML
	private void initialize() throws SQLException {

		getAllEmployeeData();
		setColumnNames();
		// Initialize the person table with the two columns.
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		industryColumn.setCellValueFactory(cellData -> cellData.getValue().industryProperty());
		workTypeColumn.setCellValueFactory(cellData -> cellData.getValue().workTypeProperty());
		addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
		cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		provinceColumn.setCellValueFactory(cellData -> cellData.getValue().provinceProperty());
		postalCodeColumn.setCellValueFactory(cellData -> cellData.getValue().postalCodeProperty());
		phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
		enddateColumn.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());
		workStatusColumn.setCellValueFactory(cellData -> cellData.getValue().workStatusProperty());
		systemStatusColumn.setCellValueFactory(cellData -> cellData.getValue().systemStatusProperty());
		resumeColumn.setCellValueFactory(cellData -> cellData.getValue().resumeProperty());
		notesColumn.setCellValueFactory(cellData -> cellData.getValue().notesProperty());
		


		/*
		 * // Add some sample data employeeData.add(new Employee(1, "Jeffrey",
		 * "Nadeau")); employeeData.add(new Employee(2, "Travis", "Dreher"));
		 * employeeData.add(new Employee(3, "Wilson", "Chau"));
		 * employeeData.add(new Employee(4, "Shane", "Kelly"));
		 * employeeTable.setItems(getAllEmployeeData()); // Clear person
		 * details. showEmployeeDetails(employeeData.get(0));
		 */
		employeeTable.setItems(employeeData);
		// Listen for selection changes and show the person details when
		// changed.
		//employeeTable.getSelectionModel().selectedItemProperty()
		//		.addListener((observable, oldValue, newValue) -> showEmployeeDetails(newValue));
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
		int selectedIndex = employeeTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			employeeTable.getItems().remove(selectedIndex);
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
			employeeData.add(tempPerson);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditEmployee() {
		Employee selectedPerson = employeeTable.getSelectionModel().getSelectedItem();
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
		for (int i = 1; i < columnNames.size(); i++) {
			employeeTable.getColumns().get(i - 1).setText(columnNames.get(i));			
		}
	}

}