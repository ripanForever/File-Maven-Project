package edu.app.v1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class CreationFile{

	public void FileCreate() throws IOException {

		try {
			InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");

			Properties p = new Properties();

			if (fileInput != null) {
				p.load(fileInput);
			}

			String path = p.getProperty("path");
			String name = p.getProperty("name");

			File myfile = new File(path + name);

			if (myfile.createNewFile()) {
				System.out.print("File is created: " + myfile.getName());
			}

			else {
				System.out.print(myfile.getName() + "file already exists..");
			}
		} catch (IOException e) {
			System.out.print("Error");
		}

	}

	public void writeFile(String s) {
		try {

			InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");

			Properties p = new Properties();
			p.load(fileInput);

			String path = p.getProperty("path");
			String name = p.getProperty("name");

			// Creates a Writer using FileWriter
			FileWriter output = new FileWriter(path + name);

			// Writes string to the file
			output.write(s);
			System.out.println("Data is written to the file.");

			// Closes the writer
			output.close();
		} catch (Exception e) {
			System.out.print("Error");
		}
	}

	public String readFile() {

		String s = "";
		try {
			InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");

			Properties p = new Properties();
			p.load(fileInput);

			String path = p.getProperty("path");
			String name = p.getProperty("name");

			// Creates a reader using the FileReader
			File myFile = new File(path + name);

			Scanner ob = new Scanner(myFile);

			// Reads characters
			while (ob.hasNextLine()) {
				s = ob.nextLine();
				// System.out.print(s);
			}

			ob.close();
		} catch (Exception e) {
			System.out.print("Error");
		}
		return s;
	}
}
