package application;

import java.nio.file.Path;

public class File {

	private String fileName;
	private String fileType;
	private String fileSize;
	private Path filePath;

	public File(String pFileName, String pFileType, String pFileSize, Path pFilePath) {
        fileName = pFileName;
        fileType = pFileType;
        fileSize = pFileSize;
        filePath = pFilePath;
    }
	
	public File(Path pFilePath) {
        filePath = pFilePath;
    }
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
	}
	
	

}
