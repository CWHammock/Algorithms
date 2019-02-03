package com.warren.main;

import java.io.File;

import com.warren.schedulegreedy.GreedySchedule;

public class Driver {

	public static void main(String[] args) {
		File inputFile = new File("C:\\Users\\charl\\Desktop\\WorkStation\\Scheduling\\src\\com\\warren\\inputFile.txt");
		GreedySchedule greedySchedule = new GreedySchedule(inputFile);		
	}
}
