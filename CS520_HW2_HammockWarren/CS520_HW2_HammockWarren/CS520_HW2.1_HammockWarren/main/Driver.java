package com.warren.knapsack.main;


import java.io.FileWriter;
import java.io.IOException;

import com.warren.knapsack.fractional.FractionalKnapsack;
import com.warren.knapsack.zeroone.ZeroOneKnapsack;

public class Driver {

	public static void main(String[] args) {
		String fileName = "KnapsackTesting.txt";
		int[] weights = { 20, 24, 14, 20, 18, 20, 10, 6 };
		int[] prices = { 15, 9, 27, 12, 36, 12, 9, 12 };
		final int CAPACITY = 80;
		ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack(weights, prices, CAPACITY, fileName);
		zeroOneKnapsack.zeroOneAlgorithm();
		FractionalKnapsack fractionalKnapsack = new FractionalKnapsack(weights, prices, CAPACITY, fileName);
		fractionalKnapsack.fractionalAlgorithm();
		
		
		
		
	}

}
