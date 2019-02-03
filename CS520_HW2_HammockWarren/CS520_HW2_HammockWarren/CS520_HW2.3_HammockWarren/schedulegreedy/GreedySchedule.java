package com.warren.schedulegreedy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.warren.main.DataIO;

public class GreedySchedule {
	
	ArrayList<Jobs> jobsToBeDone = new ArrayList<>();
	ArrayList<String> finalList = new ArrayList<>();  
	int numberOfJobs;

	public GreedySchedule(File inputFile) {
		
		try {
			String[] input = DataIO.readFromFile(inputFile);

			for(int i = 1; i < input.length; i += 2) {
				Jobs jobs = new Jobs(Integer.parseInt(input[i]), Integer.parseInt(input[i+1]));
				jobsToBeDone.add(jobs);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		implementGreedyAlgorithm();
	}
	
	//used waterfall method of checking the rooms for compares.
	private void implementGreedyAlgorithm() {
		//sort the list ascending order with endtime
		Collections.sort(jobsToBeDone);
		int room = 1;
		Jobs roomOneJob = null;
		Jobs roomTwoJob = null;
		Jobs roomThreeJob = null;
		Jobs roomFourJob = null;		
		for (int i = 0; i < jobsToBeDone.size(); i++) {
			if (roomOneJob == null) { 
				roomOneJob = jobsToBeDone.get(i); 
				String jobOneToString = ("Job: " + jobsToBeDone.get(i).toString() + " done in room " + room);
				finalList.add(jobOneToString);
			}
			else if (jobsToBeDone.get(i).getStartTime() >= roomOneJob.getEndTime()){
				roomOneJob = jobsToBeDone.get(i);
				String jobOneToString = ("Job: " + jobsToBeDone.get(i).toString() + " done in room " + room);
				finalList.add(jobOneToString);
			}
			else if (jobsToBeDone.get(i).getStartTime() < roomOneJob.getEndTime()) {
				if (roomTwoJob == null) { 
					roomTwoJob = jobsToBeDone.get(i); 
					String jobTwoToString = ("Job: " + jobsToBeDone.get(i).toString() + " done in room " + (room + 1));
					finalList.add(jobTwoToString);
				}
				else if (jobsToBeDone.get(i).getStartTime() >= roomTwoJob.getEndTime()){
					roomTwoJob = jobsToBeDone.get(i);
					String jobTwoToString = ("Job: " + jobsToBeDone.get(i).toString() + " done in room " + (room + 1));
					finalList.add(jobTwoToString);
				}
				else if (jobsToBeDone.get(i).getStartTime() < roomTwoJob.getEndTime()) {
					if (roomThreeJob == null) { 
						roomThreeJob = jobsToBeDone.get(i); 
						String jobThreeToString = ("Job: " + jobsToBeDone.get(i).toString() + " done in room " + (room + 2));
						finalList.add(jobThreeToString);
					}
					else if (jobsToBeDone.get(i).getStartTime() >= roomThreeJob.getEndTime()){
						roomFourJob = jobsToBeDone.get(i);
						String jobFourToString = ("Job: " + jobsToBeDone.get(i).toString() + " done in room " + (room + 3));
						finalList.add(jobFourToString);
					}
		
				}
			}
			else {System.out.println("Sorry, no rooms available");
			}
		
	
	}
		System.out.println(finalList);
}
}
