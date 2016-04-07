package jm.local.view;

import jm.local.Main;
import jm.local.model.Employee;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TextField idField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField industryField;
    @FXML
    private TextField workTypeField;
    @FXML
    private TextField addressField;

    // Reference to the main application.
    private Main main;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public EmployeeController() {
    	// Add some sample data
        employeeData.add(new Employee(1, "Jeffrey", "Nadeau"));
        employeeData.add(new Employee(2, "Travis", "Dreher"));
        employeeData.add(new Employee(3, "Wilson", "Chau"));
        employeeData.add(new Employee(4, "Shane", "Kelly"));
    	
    }
 
    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();
    
    public ObservableList<Employee> getEmployeeData() {
        return employeeData;
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
            dialogStage.initOwner(main.getPrimaryStage());
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
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        // Clear person details.
        showEmployeeDetails(null);

        // Listen for selection changes and show the person details when changed.
        employeeTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showEmployeeDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;

        // Add observable list data to the table
        //employeeTable.setItems(main.getEmployeeData());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
    
    private void showEmployeeDetails(Employee employee) {
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
    }
    
    @FXML
    private void handleDeleteEmployee() {
        int selectedIndex = employeeTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	employeeTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewEmployee() {
    	Employee tempPerson = new Employee();
        boolean okClicked = showEmployeeEditDialog(tempPerson);
        if (okClicked) {
            getEmployeeData().add(tempPerson);
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
                showEmployeeDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(main.getPrimaryStage().getOwner());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            
            alert.showAndWait();
        }
    }
}