package jm.local;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import jm.local.view.JobMasterGUIController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Main program code
 * @author Jeffrey, Tyler, Wilson, Shane
 *
 */
public class Main extends Application {
	
    private Stage primaryStage;
	
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JobMaster");

        initJMGui();
    }//end start
    
    /**
     * Initializes the root layout.
     */
    public void initJMGui() {
        try {
            // Load from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/JobMasterGUI.fxml"));
            AnchorPane JMGui = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(JMGui);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            // Give the controller access to the main app.
            JobMasterGUIController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }//end trycatch
    }//end initJMGui
	
	public static void main(String[] args) {
		launch(args);
	}//end main
}//end Main
