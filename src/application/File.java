package application;

public class File {

	private String fileName;
	private String fileType;
	private String fileSize;
	private String filePath;

	public File(String pFileName, String pFileType, String pFileSize, String pFilePath) {
        fileName = pFileName;
        fileType = pFileType;
        fileSize = pFileSize;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
