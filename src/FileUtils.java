import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
	
	public static List<String> readFile(String filename)
	{
		List<String> result = new ArrayList<String>();
		try {
			result = Files.lines(Paths.get(filename)).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<String> autoCorrect(Stream<String> strings, String autoCorrectCase, String oldWord, String newWord)
	{
		List<String> result = new ArrayList<String>();
		if (autoCorrectCase.toLowerCase().equals("yes"))
		{
			result = strings.map(e -> e.replace(oldWord, newWord)).collect(Collectors.toList());
		}else
		{
			System.out.println("qwe");
			result = strings.map(e -> e.toLowerCase().replace(oldWord.toLowerCase(), newWord)).collect(Collectors.toList());
		}
		return result;
	}
	
	public static List<String> upperLower(Stream<String> strings, String upperLower)
	{
		List<String> result = new ArrayList<String>();
		if (upperLower.equals("Upper"))
		{
			result = strings.map(String::toUpperCase).collect(Collectors.toList());
		}else if (upperLower.equals("Lower"))
		{
			result = strings.map(String::toLowerCase).collect(Collectors.toList());
		}else
		{
			result = strings.collect(Collectors.toList());
		}
		return result;
	}
	
	public static void writeFile(String filename, List<String> contents)
	{
		Charset characterSet = Charset.defaultCharset();
		Path path = Paths.get(filename);
		try {
			Files.write(path, contents, characterSet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
