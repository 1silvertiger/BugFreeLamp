package application;



import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
	Button goButton;
	
	@FXML
	TextField searchField;
	
	@FXML
	TableColumn<String, String> colName;
	
	@FXML
	TableColumn<String, String> colPath;
	
	@FXML
	void handleClick() {
		String searchInput = searchField.getText();
		
		//Path searchPath = Paths.get(searchInput);
		
		colPath.setText(searchInput);
	}
}
