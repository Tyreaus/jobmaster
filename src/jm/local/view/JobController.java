package jm.local.view;

import jm.local.Main;
import jm.local.data.JobDataConnector;
import jm.local.model.Job;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JobController {

	@FXML
	private TableView<Job> jobTable;

	@FXML
	private TableColumn<Job, String> companyColumn;
	@FXML
	private TableColumn<Job, String> descriptionColumn;
	@FXML
	private TableColumn<Job, String> addressColumn;
	@FXML
	private TableColumn<Job, String> cityColumn;
	@FXML
	private TableColumn<Job, String> provinceColumn;
	@FXML
	private TableColumn<Job, String> postalCodeColumn;
	@FXML
	private TableColumn<Job, String> startDateColumn;
	@FXML
	private TableColumn<Job, String> enddateColumn;
	@FXML
	private TableColumn<Job, String> industryColumn;	
	@FXML
	private TableColumn<Job, String> systemStatusColumn;
	@FXML
	private TableColumn<Job, String> MarkupColumn;
	@FXML
	private TableColumn<Job, String> notesColumn;

	@FXML
	private ComboBox<String> industryFilterComboBox;
	@FXML
	private ComboBox<String> systemStatusFilterComboBox;
	@FXML
	private ComboBox<String> provincesFilterComboBox;

	private ObservableList<Job> jobData;
	private ObservableList<String> industryFilterData;
	private ObservableList<String> systemStatusFilterData;
	private ObservableList<String> provincesFilterData;

	private List<String> columnNames = null;
	private List<Integer> filterCriteria = null;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public JobController() {

	}

	public void getAlljobData() throws SQLException {
		JobDataConnector jobConnector = new JobDataConnector();

		this.columnNames = jobConnector.getJobColumnNames();

		this.jobData = jobConnector.getAllJobData();
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 * 
	 * @throws SQLException
	 */
	@FXML
	private void initialize() throws SQLException {

		filterCriteria = new ArrayList<>(3);
		filterCriteria.add(0, 0);
		filterCriteria.add(1, 0);
		filterCriteria.add(2, 0);
		

		getComboBoxFilterData();

		getAlljobData();
		setColumnNames();

		this.industryFilterComboBox.setItems(this.industryFilterData);
		this.systemStatusFilterComboBox.setItems(this.systemStatusFilterData);
		this.provincesFilterComboBox.setItems(this.provincesFilterData);

		// Initialize the person table with the two columns.
		this.companyColumn.setCellValueFactory(cellData -> cellData.getValue().companyProperty());
		this.descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		this.addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
		this.cityColumn.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
		this.provinceColumn.setCellValueFactory(cellData -> cellData.getValue().provinceProperty());
		this.postalCodeColumn.setCellValueFactory(cellData -> cellData.getValue().postalCodeProperty());
		this.startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
		this.enddateColumn.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());
		this.MarkupColumn.setCellValueFactory(cellData -> cellData.getValue().markupProperty());
		this.industryColumn.setCellValueFactory(cellData -> cellData.getValue().industryProperty());
		this.systemStatusColumn.setCellValueFactory(cellData -> cellData.getValue().systemStatusProperty());
		this.notesColumn.setCellValueFactory(cellData -> cellData.getValue().notesProperty());

		this.jobTable.setItems(this.jobData);

		jobTable.setRowFactory(tv -> {
			TableRow<Job> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					handleEditjob();
				}
			});
			return row;
		});

	}

	public boolean showJobEditDialog(Job job) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/jobEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit job");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// dialogStage.initOwner(main.getPrimaryStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the job into the controller.
			JobEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setJob(job);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 * 
	 * @param person
	 *            the person or null
	 */

	/*
	 * private void showjobDetails(job job) { if (job != null) { // Fill the
	 * labels with info from the person object.
	 * idField.setText(Integer.toString(job.getId()));
	 * firstNameField.setText(job.getFirstName());
	 * lastNameField.setText(job.getLastName());
	 * industryField.setText(job.getIndustry());
	 * workTypeField.setText(job.getWorkType());
	 * addressField.setText(job.getAddress()); } else { // Person is null,
	 * remove all the text. idField.setText(""); firstNameField.setText("");
	 * lastNameField.setText(""); industryField.setText("");
	 * workTypeField.setText(""); addressField.setText(""); } }
	 */

	@FXML
	private void handleDeletejob() {
		int selectedIndex = this.jobTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			this.jobTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 * 
	 * @throws SQLException
	 */
	@FXML
	private void handleNewjob() throws SQLException {
		Job tempPerson = new Job();
		boolean okClicked = showJobEditDialog(tempPerson);
		if (okClicked) {
			this.jobData.add(tempPerson);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditjob() {
		Job selectedPerson = this.jobTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = showJobEditDialog(selectedPerson);
			if (okClicked) {
				// showjobDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	private void setColumnNames() {
		for (int i = 1; i < this.columnNames.size(); i++) {
			if (this.columnNames.size() > 0) {

				this.jobTable.getColumns().get(i - 1).setText(this.columnNames.get(i));
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("No Column Names");
				alert.setContentText("Only " + columnNames.toString() + ", I've Lost It All!");

				alert.showAndWait();
			}
		}
	}

	@FXML
	private void handleIndustryFilterComboBox() {
		this.industryFilterComboBox.setOnAction((event) -> {
			Integer selectedIndustry = this.industryFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
			this.filterCriteria.set(0, selectedIndustry);
			getFilteredjobData();

		});

	}

	@FXML
	private void handleSystemStatusFilterComboBox() {
		this.systemStatusFilterComboBox.setOnAction((event) -> {
			Integer selectedCategory = this.systemStatusFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
			this.filterCriteria.set(1, selectedCategory);
			getFilteredjobData();

		});
	}

	@FXML
	private void handleProvincesFilterComboBox() {
		this.provincesFilterComboBox.setOnAction((event) -> {
			Integer selectedProvince = this.provincesFilterComboBox.getSelectionModel().getSelectedIndex() + 1;
			this.filterCriteria.set(2, selectedProvince);
			getFilteredjobData();
		});
	}

	private void getFilteredjobData() {

		JobDataConnector jobConnector = new JobDataConnector();

		this.columnNames = jobConnector.getJobColumnNames();

		this.jobData = jobConnector.getFilteredJobData(this.filterCriteria.get(0), this.filterCriteria.get(1),
				this.filterCriteria.get(2));
		this.jobTable.setItems(this.jobData);
	}

	private void getComboBoxFilterData() {

		JobDataConnector jobConnector = new JobDataConnector();

		this.industryFilterData = jobConnector.getIndustries();
		this.systemStatusFilterData = jobConnector.getSystemStatuses();
		this.provincesFilterData = jobConnector.getProvinces();
		setIndustryFilterComboBox();
		setSystemStatusFilterComboBox();
		setProvincesFilterComboBox();

	}

	private void setIndustryFilterComboBox() {
		industryFilterComboBox.setCellFactory((comboBox) -> {
			return new ListCell<String>() {
				@Override
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item);
					}
				}
			};
		});

		this.industryFilterComboBox.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				handleIndustryFilterComboBox();
			}

		});

	}

	private void setSystemStatusFilterComboBox() {
		systemStatusFilterComboBox.setCellFactory((comboBox) -> {
			return new ListCell<String>() {
				@Override
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item);
					}
				}
			};
		});

		this.systemStatusFilterComboBox.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				handleSystemStatusFilterComboBox();
			}

		});

	}


	private void setProvincesFilterComboBox() {
		provincesFilterComboBox.setCellFactory((comboBox) -> {
			return new ListCell<String>() {
				@Override
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item);
					}
				}
			};
		});

		this.provincesFilterComboBox.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue ov, String t, String t1) {
				handleProvincesFilterComboBox();
			}

		});
	}

	@FXML
	private void handleClearFiltersButton() {
		this.filterCriteria.set(0, 0);
		this.filterCriteria.set(1, 0);
		this.filterCriteria.set(2, 0);
		this.industryFilterComboBox.getSelectionModel().select(-1);
		this.systemStatusFilterComboBox.getSelectionModel().select(-1);
		this.provincesFilterComboBox.getSelectionModel().select(-1);

		getFilteredjobData();
	}

}
