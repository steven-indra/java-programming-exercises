import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Settings mySetting = new Settings();
		List<String> input = FileUtils.readFile(mySetting.getInputFilename());

		String[] a = mySetting.getAutoCorrect().split("-");
		input = FileUtils.autoCorrect(input.stream(), mySetting.getAutoCorrectCase(), a[0].trim(), a[1].trim());
		if (!mySetting.getUpperLowerCase().toLowerCase().equals("normal"))
		{
			input = FileUtils.upperLower(input.stream(), mySetting.getUpperLowerCase());
		}
		FileUtils.writeFile(mySetting.outputFilename, input);
	}

}
