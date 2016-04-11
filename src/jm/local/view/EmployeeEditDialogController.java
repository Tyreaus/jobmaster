package jm.local.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jm.local.model.Employee;
/*
import ch.makery.address.util.DateUtil;
*/

/**
 * Dialog to edit details of an employee.
 */
public class EmployeeEditDialogController {

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



    private Stage dialogStage;
    private Employee employee;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;

        idField.setText(Integer.toString(employee.getId()));
        firstNameField.setText(employee.getFirstName());
        lastNameField.setText(employee.getLastName());
        industryField.setText(employee.getIndustry());
        workTypeField.setText(employee.getWorkType());
        addressField.setText(employee.getAddress());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	employee.setId(Integer.parseInt(idField.getText()));
        	employee.setFirstName(firstNameField.getText());
        	employee.setLastName(lastNameField.getText());
        	employee.setIndustry(industryField.getText());
        	employee.setWorkType(workTypeField.getText());
        	employee.setAddress(addressField.getText());
        	

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (idField.getText() == null || idField.getText().length() == 0) {
            errorMessage += "No valid ID number!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(idField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid ID number (must be an integer)!\n"; 
            }
        }
        
        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (industryField.getText() == null || industryField.getText().length() == 0) {
            errorMessage += "No valid industry!\n"; 
        }

        if (workTypeField.getText() == null || workTypeField.getText().length() == 0) {
            errorMessage += "No valid work type!\n"; 
        }

        if (addressField.getText() == null || addressField.getText().length() == 0) {
            errorMessage += "No valid address!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}