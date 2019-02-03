package com.warren.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataIO {

	public static String[] readFromFile(File file) throws FileNotFoundException, IOException {
		StringBuilder fileString = new StringBuilder();

		try(FileReader fileReader = new FileReader(file)){
			int ch;
			try {
				while((ch = fileReader.read()) != -1) {
					fileString.append((char)ch);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String stringBeforeParseFile = fileString.toString();
		String[] stringArray = stringBeforeParseFile.split(",|\\s");
		
		return stringArray;
	}
}
