package com.warren.knapsack.fractional;

import com.warren.knapsack.main.KnapSack;
import com.warren.knapsack.main.Item;
import com.warren.knapsack.main.WriteToFile;

public class FractionalKnapsack {
	private KnapSack knapSack;
	private String fileName;
	
	public FractionalKnapsack(int[] weight, int[] price, int capacity, String fileName) {
		knapSack = new KnapSack(weight, price, capacity);
		this.fileName = fileName;
	}

	public void fractionalAlgorithm() {
		//show list before sort
		WriteToFile.writeToTestFile("Fractional Knapsack", fileName);
		WriteToFile.writeToTestFile("Starting List: ", fileName);
		WriteToFile.writeToTestFile(knapSack.toString(), fileName);
		WriteToFile.writeToTestFile("After Sorting by Value in Desending Order: ", fileName);
		//sort list in desending order and show list
		knapSack.sortItemList();
		WriteToFile.writeToTestFile(knapSack.toString(), fileName);
		//keep track of iterations
		int weight = 0;
		int counter = 0;
		//keeps adding to knapsack until it is left with the last item that could not be added
		while(true) {
			double itemWeight = knapSack.getItemListItemAt(counter).getWeight();
			if (weight + itemWeight < knapSack.getWeightKnapsack()) {
				knapSack.addItemToKnapsack(knapSack.getItemListItemAt(counter));
				knapSack.removeItemFromItemList(counter);
				weight += itemWeight;
				WriteToFile.writeToTestFile(knapSack.toString(), fileName);
				String weightIs = "Knapsack Weight is: " + Integer.toString(weight);
				WriteToFile.writeToTestFile(weightIs, fileName);
			}else {break;}	
		}
		
		//get unused space and calculate outstanding value
		double unusedSpace = knapSack.getWeightKnapsack() - (double)weight;
		//convert last item on itemlist
		Item lastItemOnItemList = convertItemListFractional(knapSack.getItemListItemAt(counter), unusedSpace);
		//convert last item on knapsackList
		Item lastItemOnKnapsackList = convertKnapsackItemFractional(knapSack.getItemListItemAt(counter), unusedSpace);
		//delete last item on itemList
		knapSack.deleteItemInItemList(counter);
		//add converted item to itemList and knapsackList
		knapSack.addItemToItemList(lastItemOnItemList);
		knapSack.addItemToKnapsack(lastItemOnKnapsackList);
		weight += lastItemOnKnapsackList.getWeight();
		WriteToFile.writeToTestFile(knapSack.toString(), fileName);
		String newWeight = "Knapsack Weight is: " + Integer.toString(weight);
		WriteToFile.writeToTestFile(newWeight, fileName);
	}
	
	private Item convertItemListFractional(Item itemToConvert, double remainder) {
		double weightLeft = (double)itemToConvert.getWeight() - remainder;
		double percentChange = weightLeft/(double)itemToConvert.getWeight();
		double priceLeft = (double)itemToConvert.getPrice() * percentChange;
		Item itemToReturn = new Item(weightLeft, priceLeft);
		return itemToReturn;
	}
	private Item convertKnapsackItemFractional(Item itemToConvert, double remainder) {
		double weightLeft = remainder;
		double percentChange = weightLeft/(double)itemToConvert.getWeight();
		double priceLeft = (double)itemToConvert.getPrice() * percentChange;
		Item itemToReturn = new Item(weightLeft, priceLeft);
		return itemToReturn;
	}
}
