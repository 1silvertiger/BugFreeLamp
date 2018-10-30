package application;

import javafx.beans.property.SimpleStringProperty;

public class File {

	private SimpleStringProperty fileName;
	private SimpleStringProperty fileType;
	private SimpleStringProperty fileSize;
	private SimpleStringProperty filePath;

	private File(String pFileName, String pFileType, String pFileSize, String pFilePath) {
        fileName = new SimpleStringProperty(pFileName);
        fileType = new SimpleStringProperty(pFileType);
        fileSize = new SimpleStringProperty(pFileSize);
        filePath = new SimpleStringProperty(pFilePath);
    }
	
	public SimpleStringProperty getFileName() {
		return fileName;
	}

	public void setFileName(SimpleStringProperty fileName) {
		this.fileName = fileName;
	}

	public SimpleStringProperty getFileType() {
		return fileType;
	}

	public void setFileType(SimpleStringProperty fileType) {
		this.fileType = fileType;
	}

	public SimpleStringProperty getFileSize() {
		return fileSize;
	}

	public void setFileSize(SimpleStringProperty fileSize) {
		this.fileSize = fileSize;
	}

	public SimpleStringProperty getFilePath() {
		return filePath;
	}

	public void setFilePath(SimpleStringProperty filePath) {
		this.filePath = filePath;
	}
	

}
