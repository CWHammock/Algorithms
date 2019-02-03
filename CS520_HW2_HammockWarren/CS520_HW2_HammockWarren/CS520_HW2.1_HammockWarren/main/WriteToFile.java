package com.warren.knapsack.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class WriteToFile {
	
	public static void writeToTestFile(String input, String fileName) {
		String[] outputArray = input.split("\n");
		File file = new File("C:\\Users\\charl\\Desktop\\WorkStation\\KnapSackProblem\\src\\com\\warren\\knapsack\\" + fileName);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			for(String item: outputArray) {
				writer.write(item);
				writer.write(System.lineSeparator());
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
