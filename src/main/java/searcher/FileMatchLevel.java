package searcher;

public class FileMatchLevel implements Comparable<FileMatchLevel> {
	private String fileName;
	private Double match;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Double getMatch() {
		return match;
	}

	public void setMatch(Double match) {
		this.match = match;
	}

	// To sort a object array by its "match"
	public int compareTo(FileMatchLevel compareFileMatchLevel) {

		double compareMatch = ((FileMatchLevel) compareFileMatchLevel).getMatch();

		// Descending order
		if (this.match>compareMatch){
			return -1;
		} else if (this.match<compareMatch){
			return 1;
		} else{
			return 0;
		}

	}

}
