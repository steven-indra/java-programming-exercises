import java.util.List;

public class Settings {

	String inputFilename, outputFilename, autoCorrect, autoCorrectCase, upperLowerCase;

	public Settings()
	{
		List<String> a = FileUtils.readFile("settings.txt");
		this.inputFilename = a.get(0).split(":")[1].trim();
		this.outputFilename = a.get(1).split(":")[1].trim();
		this.upperLowerCase = a.get(2).split(":")[1].trim();
		this.autoCorrect = a.get(3).split(":")[1].trim();
		this.autoCorrectCase = a.get(4).split(":")[1].trim();
		
	}

	public String getAutoCorrectCase() {
		return autoCorrectCase;
	}

	public String getAutoCorrect() {
		return autoCorrect;
	}

	public String getInputFilename() {
		return inputFilename;
	}

	public String getOutputFilename() {
		return outputFilename;
	}

	public String getUpperLowerCase() {
		return upperLowerCase;
	}
	
}
