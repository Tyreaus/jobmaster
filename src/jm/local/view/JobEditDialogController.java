package jm.local.view;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jm.local.model.Client;
import jm.local.model.Job;
/*
import ch.makery.address.util.DateUtil;
*/

/**
 * Dialog to edit details of an employee.
 */
public class JobEditDialogController {

    @FXML
    private TextField idField;
    @FXML
    private TextField companyField;
    @FXML
    private TextField contactField;
    @FXML
    private TextField industryField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;



    private Stage dialogStage;
    private Job job;
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
    public void setJob(Job job) {
        this.job = job;

        /*idField.setText(Integer.toString(job.getId()));
        companyField.setText(job.getCompany());
        contactField.setText(job.getContact());
        industryField.setText(job.getIndustry());
        emailField.setText(job.getEmail());
        addressField.setText(job.getAddress());*/
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
        	/*client.setId(Integer.parseInt(idField.getText()));
        	client.setCompany(companyField.getText());
        	client.setContact(contactField.getText());
        	client.setIndustry(industryField.getText());
        	client.setEmail(emailField.getText());
        	client.setAddress(addressField.getText());*/
        	

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
        
        if (companyField.getText() == null || companyField.getText().length() == 0) {
            errorMessage += "No valid company!\n"; 
        }
        if (contactField.getText() == null || contactField.getText().length() == 0) {
            errorMessage += "No valid contact!\n"; 
        }
        if (industryField.getText() == null || industryField.getText().length() == 0) {
            errorMessage += "No valid industry!\n"; 
        }

        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "No valid email!\n"; 
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