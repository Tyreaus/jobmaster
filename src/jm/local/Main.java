package jm.local;
	
/*
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
*/

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main program code
 * @author Jeffrey, Tyler, Wilson, Shane
 *
 */
public class Main extends Application {
	
	@Override
	public void start(Stage stage) {
		try {
			
		    stage.setTitle("JobMaster");
		    AnchorPane layout = FXMLLoader.load(
		      new URL(Main.class.getResource("view/JobMasterGUI.fxml").toExternalForm())
		    );
		    stage.setScene(new Scene(layout));
		    stage.show();
			
			/*
			Parent root = FXMLLoader.load(getClass().getResource("view/JobMasterGUI.fxml"));
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("JobMaster");
			primaryStage.show();
			*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
