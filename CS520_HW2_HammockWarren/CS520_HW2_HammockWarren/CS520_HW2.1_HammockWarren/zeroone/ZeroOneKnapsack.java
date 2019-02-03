package com.warren.knapsack.zeroone;

import com.warren.knapsack.main.KnapSack;
import com.warren.knapsack.main.WriteToFile;

public class ZeroOneKnapsack {
	private KnapSack knapSack;
	private String fileName;
	
	public ZeroOneKnapsack(int[] weight, int[] price, int capacity, String fileName) {
		knapSack = new KnapSack(weight, price, capacity);
		this.fileName = fileName;
	}
	
	public void zeroOneAlgorithm() {
		WriteToFile.writeToTestFile("Zero and One Algorithm", fileName);
		WriteToFile.writeToTestFile("Starting List: ", fileName);
		WriteToFile.writeToTestFile(knapSack.toString(), fileName);
		WriteToFile.writeToTestFile("After Sorting by Value in Desending Order: ", fileName);
		knapSack.sortItemList();
		WriteToFile.writeToTestFile(knapSack.toString(), fileName);
		int weight = 0;
		String thisIsWeight = "The weight for knapsack is: ";
		for (int i = 0; i < knapSack.getItemListSize(); i++) {
			double itemWeight = knapSack.getItemListItemAt(i).getWeight();
			if (itemWeight + weight < knapSack.getWeightKnapsack()) {
				weight += knapSack.getItemListItemAt(i).getWeight();
				knapSack.addItemToKnapsack(knapSack.getItemListItemAt(i));
				knapSack.removeItemFromItemList(i);
				WriteToFile.writeToTestFile(knapSack.toString(), fileName);
				String weightIs = "Knapsack Weight is: " + Integer.toString(weight);
				WriteToFile.writeToTestFile(weightIs, fileName);
				--i;
			}
		}
		double unusedSpace = knapSack.getWeightKnapsack() - (double)weight;
		String weightOutput = "Left Over Space: " + unusedSpace;
		WriteToFile.writeToTestFile(weightOutput, fileName);	
	}
}
