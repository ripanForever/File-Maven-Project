package edu.app.v1;

import java.io.File;
//import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.*;
//import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//set the priority of the test execution by FixMethodOrder
@FixMethodOrder(MethodSorters.DEFAULT)
public class CreationFileTest {

	CreationFile ob = new CreationFile();
	InputStream configInput = getClass().getClassLoader().getResourceAsStream("configTest.properties");
//	FileReader configInput;
	String path = "";
	String name = "";
	String testText = "";

	@Before
	public void initialize() throws Exception {
		
		Properties configProp = new Properties();
		configProp.load(configInput);
		String profileName = configProp.getProperty("profileName");
		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\profilesTest\\" + "configTest." + profileName + ".properties");

//		fileInput = new FileReader(
//				"C:\\Users\\a835686\\eclipse-workspace\\fileOperations\\src\\test\\resources\\configTest.properties");
		Properties p = new Properties();
		p.load(fileInput);
		path = p.getProperty("path");
		name = p.getProperty("name");
		testText = p.getProperty("testText");

	}

	@Before
	public void createOutputFile() throws IOException {

		ob.FileCreate();
	}

//	@After
//	public void deleteOutputFile() throws IOException {
//		
//		FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testConfig.properties");
//		
//		Properties p = new Properties();
//		p.load(fileInput);
//		
//		String path = p.getProperty("path");
//		String name = p.getProperty("name");
//		
//		File fileOutput = new File(path + name);
//		
//		fileOutput.delete();
//		System.out.println("Deleted the file: " + fileOutput.getName());
//	}

	@Test
	public void createFileTest() throws IOException {

		File fileOutput = new File(path + name);

		/* Testing with Assert function */
		assertEquals(true, fileOutput.exists());
	}

	@Test
	public void writeFiletest() throws IOException {

//		Properties p = new Properties();
//		p.load(fileInput);
////		String s= p.getProperty("outputText");  // This code is overwriting the file
//
//		String testText = p.getProperty("testText");
		String s = "I am Ripan";
		ob.writeFile(s);

		/* Testing with Assert function */
		assertEquals(s, ob.readFile());

	}

	@Test
	public void readFileTest() throws IOException {
		/* Testing with Assert function */
		assertEquals(testText, ob.readFile());
	}
}
