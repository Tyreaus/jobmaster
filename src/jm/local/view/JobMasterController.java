package jm.local.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
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
	
	ObservableList<Data> pieChartData;
	ObservableList<Data> barChartData;
	
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
    	    
    	    if(selectedView.equals("Clients")){
    	    	setPieChart();
    	    	setBarChart();
    	    }
    	    else if(selectedView.equals("Jobs")){
    	    	
    	    }
    	    else if(selectedView.equals("Employees")){
    	    	
    	    }
    	    else{
    	    	
    	    }
    	});
    	
    }//end Initialize
    
    private void setPieChart(){
    	//Get data from the database based on the query
    	//NOTE: May be able to pass selectedView, line 56,
    	//	to this method and use it to get a query
    	//	that can be parsed into data obj.s
    	
    	//Create the pie chart items
    	pieChartData = FXCollections.observableArrayList(
    			new Data("Item1", 25),
    			new Data("Item2", 75)
    			);
    	
    	//Set the chart data to the pie chart
    	byIndChart.setData(pieChartData);
    	byIndChart.setTitle("Clients By Industry");
    }
    
    private void setBarChart(){
    	//Get data from the database based on the query
    	//NOTE: May be able to pass selectedView, line 56,
    	//	to this method and use it to get a query
    	//	that can be parsed into data obj.s
    	
    	//Create the bar chart items
    	barChartData = FXCollections.observableArrayList(
    			new Data("Item1", 25),
    			new Data("Item2", 75)
    			);
    	
    	//Set the chart data to the bar chart
    	top10Chart.setData(barChartData);
    	top10Chart.setTitle("Top 10 Clients");
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
