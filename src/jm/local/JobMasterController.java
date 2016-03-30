
package jm.local;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableView;

/** JavaFX fxml controller for fruit combo fxml demo application. */
public class JobMasterController implements Initializable {

  @FXML //  fx:id="viewComboBox"
  private ComboBox<String> viewComboBox; // Value injected by FXMLLoader

  @FXML //  fx:id="viewCBLabel"
  private Label viewCBLabel; // Value injected by FXMLLoader
  
  @FXML //fx:id="emplByIndChart"
  private PieChart byIndChart; // Value injected by FXMLLoader
  
  @FXML //fx:id="top10EmplChart"
  private BarChart top10Chart; // Value injected by FXMLLoader
  
  @FXML //fx:id="dashboardTable"
  private TableView dashboardTable; // Value injected by FXMLLoader

  @Override // This method is called by the FXMLLoader when initialization is complete
  public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
	
	  //Asserts for required elements
	  assert viewComboBox != null : "fx:id=\"viewComboBox\" was not injected: check your FXML file 'JobMasterGUI.fxml'.";
	  assert viewCBLabel != null : "fx:id=\"viewCBLabel\" was not injected: check your FXML file 'JobMasterGUI.fxml'.";
	  assert byIndChart != null : "fx:id=\"emplByIndChart\" was not injected: check your FXML file 'JobMasterGUI.fxml'.";
	  assert top10Chart != null : "fx:id=\"top10EmplChart\" was not injected: check your FXML file 'JobMasterGUI.fxml'.";
	  assert dashboardTable != null : "fx:id=\"dashboardTable\" was not injected: check your FXML file 'JobMasterGUI.fxml'.";
	  
	  
	// listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
	    viewComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	      @Override public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
	        if (oldFruit != null) {
	          switch(oldFruit) {
	            case "Employee":  System.out.println("Change Done"); break;
	            case "Client":  System.out.println("Change Done"); break;
	            case "Job":      System.out.println("Change Done"); break;
	          }
	        }
	        if (newFruit != null) {
	          switch(newFruit) {
	            case "Employee":  System.out.println("Change Done"); break;
	            case "Client":  System.out.println("Change Done"); break; 
	            case "Job":     System.out.println("Change Done"); break;
	          }
	        }  
	      }
	    });
  }//end initialize
}//end JobMasterController