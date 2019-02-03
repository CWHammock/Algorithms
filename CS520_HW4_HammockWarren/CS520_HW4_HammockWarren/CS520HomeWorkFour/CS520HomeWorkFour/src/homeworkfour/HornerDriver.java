/************************************************************
Class HornerDriver
Creator: C. Warren Hammock
Date: 4.26.18
Additional Files: HornerAlgorithm.java, inputFile.txt
Purpose: Driver class for HornerAlgorithm class. 

*************************************************************/

package homeworkfour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class HornerDriver {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\charl\\Desktop\\School\\Algorithm Analysis\\Homework\\CS520_HW4_HammockWarren\\CS520HomeWorkFour\\CS520HomeWorkFour\\inputFile.txt");
		
		try {
			HornerAlgorithm hornerAlgorithm = new HornerAlgorithm(readInputToString(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer> readInputToString(File file) throws IOException {
		ArrayList<Integer> inputString = new ArrayList<>();
		FileReader fileReader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(fileReader);
		String stringToParse = bReader.readLine(); 
		bReader.close();
//		test
//		System.out.println(stringToParse);
		String[] stringArrayParsed = stringToParse.split(",");
		for(int i = 0; i < stringArrayParsed.length; i++) {
			int number = Integer.parseInt(stringArrayParsed[i]);
			inputString.add(number);
		}

		return inputString;
	}
	

}
