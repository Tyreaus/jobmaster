package jm.local.view;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import jm.local.Main;

public class JobMasterController {

	@FXML
	private ComboBox<String> viewComboBox;
	
	@FXML
	private Label viewCBLabel;
	
	@FXML
	private BarChart top10Chart;
	
	@FXML
	private PieChart byIndChart;
	
	@FXML
	private TableView dashboardTable;
	
	//Reference to main application
	
	private Main mainApp;
	
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public JobMasterController() {
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    	// Handle ComboBox event.
    	viewComboBox.setOnAction((event) -> {
    	    String selectedView = viewComboBox.getSelectionModel().getSelectedItem();
    	    
    	});
    	
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }//end setMainApp
	
}//end JobMasterController
