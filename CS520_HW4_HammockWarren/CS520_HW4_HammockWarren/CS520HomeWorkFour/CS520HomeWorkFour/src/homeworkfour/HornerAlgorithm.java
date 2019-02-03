/************************************************************
Class HornerAlgorithm
Creator: C. Warren Hammock
Date: 4.26.18
Additional Files: HornerDriver.java, inputFile.txt
Purpose: Use Horner Method to solve polynomials.  Takes each coefficent and adds to total.
multiplies total by value of x.  does this for each coefficent until an answer is returned. 

*************************************************************/


package homeworkfour;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class HornerAlgorithm {
	
	public HornerAlgorithm(ArrayList<Integer> numberList) throws IOException {
		//reverse order of list
		Collections.reverse(numberList);
		//get value of x
		int valueOfX = numberList.get(numberList.size() - 1);
		int answer = 0;
		numberList.remove(numberList.size() - 1);
		writeToFile("For the decreasing power of x coefficents: " + numberList);
//		test output		
//		System.out.println("Value of x = " + Integer.toString(valueOfX));
		writeToFile("Value of x = " + Integer.toString(valueOfX));
		for (int i = 0; i < numberList.size(); i++) {
			if (i == 0) {
//				test output
//				System.out.println("Starting Level: " + Integer.toString(i + 1));
				writeToFile("Starting Level: " + Integer.toString(i + 1));
				answer = numberList.get(0);
//				test output
//				System.out.println("Start at: " + Integer.toString(answer));
				writeToFile("Start at: " + Integer.toString(answer));
			}
			else {
				answer *= valueOfX;
//				test output
//				System.out.println("Level " + Integer.toString(i + 1));
				writeToFile("Level " + Integer.toString(i + 1));
//				test output
//				System.out.println("Multiplication step: " + Integer.toString(answer));
				writeToFile("Multiplication step: " + Integer.toString(answer));
				int addNumberToAnswer = answer + numberList.get(i);
				answer = addNumberToAnswer;
//				test output
//				System.out.println("Addition Step: " + Integer.toString(answer));
				writeToFile("Addition Step: " + Integer.toString(answer));
			}
		}
//		test output
//		System.out.print("For the polynomial: " + numberList + ", with x having a value of: " 
//						+ valueOfX + " the answer is: " + Integer.toString(answer) );
		writeToFile("For the polynomial: " + numberList + ", with x having a value of: " 
				+ valueOfX + " the answer is: " + Integer.toString(answer) );
	}
	
	private void writeToFile(String output) throws IOException {
		File file = new File("C:\\Users\\charl\\Desktop\\School\\Algorithm Analysis\\Homework\\CS520_HW4_HammockWarren\\CS520HomeWorkFour\\CS520HomeWorkFour\\outputFile.txt");
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		fileWriter.write(output + "\r\n");
		fileWriter.close();
		
	}

}
