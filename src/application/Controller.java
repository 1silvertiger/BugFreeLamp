package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
	
	@FXML
	Button goButton;	
	@FXML
	TextField searchField;	
	@FXML
	TableView<File> table;
	@FXML
	TableColumn<File, String> colName;
	@FXML
	TableColumn<File, String> colType;
	@FXML
	TableColumn<File, String> colSize;	
	@FXML
	TableColumn<File, String> colPath;
	
	@FXML
	void handleClick() {
		String searchInput = searchField.getText();
		
		ObservableList<File> data = FXCollections.observableArrayList(
				new File("Jacob", "File", "100 KB", "C:\\Users\\andri\\Desktop"),
			    new File("Isabella", "Directory", "100 KB", "C:\\Users\\andri\\Desktop"),
			    new File("Ethan","File", "100 KB", "C:\\Users\\andri\\Desktop"),
			    new File("Emma", "Directory", "100 KB", "C:\\Users\\andri\\Desktop"),
			    new File("Michael", "File", "100 KB", "C:\\Users\\andri\\Desktop")
			);
		
		colName.setCellValueFactory(new PropertyValueFactory<>("fileName"));
		colType.setCellValueFactory(new PropertyValueFactory<>("fileType"));
		colSize.setCellValueFactory(new PropertyValueFactory<>("fileSize"));
		colPath.setCellValueFactory(new PropertyValueFactory<>("filePath"));
				
		table.setItems(data);
		
		System.out.println("placeholder");
		//colPath.setText(searchInput);
	}
}
