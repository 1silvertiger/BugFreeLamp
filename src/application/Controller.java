package application;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	TableColumn<File, Path> colPath;
	@FXML
	Label numberOfItemsLbl;
	@FXML
	Label displayNumberOfItems;
	
	@FXML
	void handleClick() {
		
		/*
		 * String rootPath = "C:/";
		String searchInput = "glob:" + searchField.getText();
		ObservableList<File> data = FXCollections.observableArrayList();
		
		try {
			System.out.println(browse(searchInput, rootPath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		String searchInput = searchField.getText();
		Path searchInputPath = Paths.get(searchInput);
		ObservableList<File> data = FXCollections.observableArrayList();
		List<Path> searchOutput = new ArrayList<>();
		String fileTypeValue;
		long fileSizeValue;
		
		try {
			searchOutput =  Files.walk(Paths.get(searchInput)).collect(Collectors.toList());
			
			for(Path path : searchOutput) {
				BasicFileAttributes fileAttr = Files.readAttributes(path, BasicFileAttributes.class);
				if(!path.equals(searchInputPath)) {
					Path pathName = searchInputPath.relativize(path);
					
					if(fileAttr.isDirectory()) {
						fileTypeValue = "Folder";
					} else if (fileAttr.isSymbolicLink()) {
						fileTypeValue = "Shortcut";
					} else if(fileAttr.isRegularFile()) {
						fileTypeValue = "File";
					} else {
						fileTypeValue = "Other";
					}
					
					fileSizeValue = fileAttr.size();
					
					data.add(new File(pathName, fileTypeValue, fileSizeValue, path));
				}
			}
				/*.filter(Files::isDirectory)
				.forEach(path -> data.add(new File("Name", "Folder", path)));*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				/*new File("Jacob", "File", "100 KB", "C:\\Users\\andri\\Desktop"),
			    new File("Isabella", "Directory", "100 KB", "C:\\Users\\andri\\Desktop"),
			    new File("Ethan","File", "100 KB", "C:\\Users\\andri\\Desktop"),
			    new File("Emma", "Directory", "100 KB", "C:\\Users\\andri\\Desktop"),
			    new File("Michael", "File", "100 KB", "C:\\Users\\andri\\Desktop")
			);*/
		
		colName.setCellValueFactory(new PropertyValueFactory<>("fileName"));
		colType.setCellValueFactory(new PropertyValueFactory<>("fileType"));
		colSize.setCellValueFactory(new PropertyValueFactory<>("fileSize"));
		colPath.setCellValueFactory(new PropertyValueFactory<>("filePath"));
				
		table.setItems(data);
		
	}
	
	public static void browse(String glob, String location) throws IOException {
		
		final PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(
				glob);
		
		Files.walkFileTree(Paths.get(location), new SimpleFileVisitor<Path>() {
			
			@Override
			public FileVisitResult visitFile(Path path,
					BasicFileAttributes attrs) throws IOException {
				if (pathMatcher.matches(path)) {
					System.out.println(path);
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc)
					throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});
	}
}
