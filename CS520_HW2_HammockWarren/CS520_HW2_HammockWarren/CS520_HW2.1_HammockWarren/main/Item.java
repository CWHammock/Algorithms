package com.warren.knapsack.main;

public class Item implements Comparable<Item> {
	private double weight;
	private double price;
	private double value;
			
	public Item(double weight, double price) {
		this.weight = weight;
		this.price = price;
		this.value = (double)price/(double)weight;
	}
	
	public double getWeight() { return this.weight; }
	public void setWeight(int weight) {this.weight = weight;}
	public double getPrice() { return this.price; }
	public void setPrice(int price) {this.price = price;}
	public double getValue() { return this.value; }
	public void setValue(int value) {this.value = value;}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Weight: " + this.getWeight() + " Price: " + this.getPrice() +
							" Value: " + Double.toString(this.getValue()) + "\n");
		String returnString = stringBuilder.toString();
		return returnString;
	}

	@Override
	public int compareTo(Item o) {
		if (this.value < o.value) return -1;
		else if (this.value > o.value) return 1;
		else return 0;
	}		
}
