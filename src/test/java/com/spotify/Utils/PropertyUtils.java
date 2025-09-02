package com.spotify.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertyUtils {

	public static Properties propertyLoader(String filepath) {

		Properties properties = null;
		BufferedReader bufferReader = null;

		try {
			bufferReader = new BufferedReader(new FileReader(filepath));
			try {
				properties = new Properties();
				properties.load(bufferReader);
			} catch (IOException e) {
				System.out.println("IOException ocured while loading propeties files" + e.getStackTrace());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found,Pleease check file location correctly!!" + e.getStackTrace());
		} finally {
			try {
				if (bufferReader != null) {
					bufferReader.close();
				}
			} catch (IOException e) {
				System.out.println("Error in closing the file");
				e.getStackTrace();
			}

		}
		return properties;

	}

}
