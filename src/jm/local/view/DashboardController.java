package jm.local.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import jm.local.Main;

public class DashboardController {

	@FXML
	private ComboBox<String> viewComboBox;
	
	@FXML
	private Label viewCBLabel;
	
	@FXML
	private BarChart<String,Number> top10Chart;
	
	@FXML
	private PieChart byIndChart;
	
	@FXML
	private TableView<String> dashboardTable;
	
	
	
	
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public DashboardController() {
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
    	 ObservableList<Data> pieChartData = FXCollections.observableArrayList(
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
    	//Code below may also be used in that method
    	//(This is just for others to work with ATM)
    	
    	//Create the bar chart data
    	Series<String, Number> barChartData = new XYChart.Series<>();
    	barChartData.setName("Jobs");
    	barChartData.getData().add(new XYChart.Data<String, Number>("Client1", 25));
    	barChartData.getData().add(new XYChart.Data<String, Number>("Client2", 50));
    	barChartData.getData().add(new XYChart.Data<String, Number>("Client3", 75));
    	
    	//Set the chart data to the bar chart
    	top10Chart.getData().clear();
    	top10Chart.getData().add(barChartData);
    	top10Chart.setTitle("Top 10 Clients");
    	
    }//end setBarChart
    
    private void setTable(){
    	
    	/*
    		//Assuming getData() exists and returns proper object type
    	private ObservableList<String> tableData = getData();
    	dashboardTable.setItems(tableData);
    		//May also be re-worked with other set chart methods
    	*/
    }//end setTable
    
   
   
}//end JobMasterController
