package com.warren.knapsack.main;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KnapSack {
	private ArrayList<Item> itemList = new ArrayList<>();
	private ArrayList<Item> itemsInKnapsack = new ArrayList<>();
	private int knapsackCapacity;
	
	public KnapSack(int[] weight, int[] price, int capacity) {
		for(int i = 0; i < weight.length; i++) {
			Item item = new Item(weight[i], price[i]);
			itemList.add(item);
		}
		this.knapsackCapacity = capacity;
	}
	
	public int getItemListSize() { return itemList.size();}
	public int getItemsInKnapsackSize() { return itemsInKnapsack.size();}
	public void deleteItemInItemList(int index) {
		itemList.remove(index);
	}
	
	public void deleteItemInItemsInKnapsack(int index) {
		itemsInKnapsack.remove(index);
	}
	
	public Item getItemListItemAt(int index){
		return itemList.get(index);
	}
	
	public Item getItemsInKnapsackAt(int index){
		return itemsInKnapsack.get(index);
	}
	
	public void sortItemList() {
		Collections.sort(itemList);
		Collections.reverse(itemList);
	}

	public void removeItemFromItemList(int index) {
		itemList.remove(index);
	}
	
	public void removeItemFromKnapsackList(int index) {
		itemsInKnapsack.remove(index);
	}
	
	public void addItemToKnapsack(Item item) {
		Item itemToAdd = new Item(item.getWeight(), item.getPrice());
		itemsInKnapsack.add(itemToAdd);
		
	}
	
	public void addItemToItemList(Item item) {
		Item itemToAdd = new Item(item.getWeight(), item.getPrice());
		itemList.add(itemToAdd);
	}
	
	public double getWeightKnapsack() {
		return (double)knapsackCapacity;
	}

	@Override
	public String toString() {
		StringBuilder arrayListString = new StringBuilder();
		int itemCounter = 1;
		int bagCounter = 1;
		arrayListString.append("ItemList is : \n");
		for(Item item: itemList) {
			arrayListString.append("Item: " + itemCounter + " " + item.toString());
			itemCounter++;
		}
		arrayListString.append("KnapsackList is : \n");
		for(Item item: itemsInKnapsack) {
			arrayListString.append("Item: " + bagCounter + " " + item.toString());
			bagCounter++;
		}
		String returnString = arrayListString.toString();
		return returnString;
	}
	

	
}
