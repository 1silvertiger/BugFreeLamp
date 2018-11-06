package application;

import java.nio.file.Path;

public class File {

	private Path fileName;
	private String fileType;
	private long fileSize;
	private Path filePath;

	public File(Path pFileName, String pFileType, long pFileSize, Path pFilePath) {
        fileName = pFileName;
        fileType = pFileType;
        fileSize = pFileSize;
        filePath = pFilePath;
    }
	
	public Path getFileName() {
		return fileName;
	}

	public void setFileName(Path fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
	}
	
	

}
