package jm.local.view;

import javafx.fxml.FXML;
import jm.local.Main;

public class JobMasterGUIController {

	
	
	private Main mainApp;
	
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public JobMasterGUIController() {
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    	
    	
    }//end Initialize
    
    
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }//end setMainApp
	
}//end JobMasterController
