import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;


public class FileUtilsTest {

	@Test
	public void testReadFile() {
		String inputFile = "unittest.txt";
		FileUtils.readFile(inputFile);
		assertNotNull(Paths.get(inputFile));
		
		List<String> result = new ArrayList<String>();
		try {
			result = Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result.get(0), "asd");
		assertEquals(result.get(1), "qwe");
		assertEquals(result.get(2), "zxc");
		assertEquals(result.size(), 3);
		
	}
	
	@Test
	public void testWriteFile() {
		String outputFile = "testwrite.txt";
		List<String> content = new ArrayList<String>();
		content.add("a");
		content.add("B");
		FileUtils.writeFile(outputFile, content);
		assertNotNull(Paths.get(outputFile));
		
		List<String> result = new ArrayList<String>();
		try {
			result = Files.lines(Paths.get(outputFile)).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result.get(0), "a");
		assertEquals(result.get(1), "B");
		assertEquals(result.size(), 2);
	}

	@Test
	public void testUpperLower() {
		List<String> content = new ArrayList<String>();
		content.add("a");
		content.add("B");
		
		content = FileUtils.upperLower(content.stream(), "Normal");
		assertEquals(content.get(0), "a");
		assertEquals(content.get(1), "B");
		
		content = FileUtils.upperLower(content.stream(), "Upper");
		assertEquals(content.get(0), "A");
		assertEquals(content.get(1), "B");
		
		content = FileUtils.upperLower(content.stream(), "Lower");
		assertEquals(content.get(0), "a");
		assertEquals(content.get(1), "b");
	}
	
	@Test
	public void testAutoCorrect() {
		List<String> content = new ArrayList<String>();
		content.add("qwe");
		content.add("zxc");
		content.add("asd");
		content.add("jkl");
		content.add("asd Qwe qwe zxc");
		
		List<String> result = new ArrayList<String>();
		result = FileUtils.autoCorrect(content.stream(), "yes", "qwe", "a");
		assertEquals(result.get(0), "a");
		assertEquals(result.get(1), "zxc");
		assertEquals(result.get(2), "asd");
		assertEquals(result.get(3), "jkl");
		assertEquals(result.get(4), "asd Qwe a zxc");
		
		result = FileUtils.autoCorrect(content.stream(), "no", "qwe", "a");
		assertEquals(result.get(0), "a");
		assertEquals(result.get(1), "zxc");
		assertEquals(result.get(2), "asd");
		assertEquals(result.get(3), "jkl");
		assertEquals(result.get(4), "asd a a zxc");
		
	}
}
