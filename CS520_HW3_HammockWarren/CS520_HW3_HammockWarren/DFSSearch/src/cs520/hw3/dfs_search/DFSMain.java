package cs520.hw3.dfs_search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DFSMain {
	//Driver
	public static void main(String[] args) throws IOException {
		//store mapping of family members positions with numerical values
		HashMap<Integer, String> familyMap = new HashMap<Integer, String>();
		familyMap.put(0, "God Father");
		familyMap.put(1, "TinyTown Boss");
		familyMap.put(2, "BigTown Boss");
		familyMap.put(3, "TT Boss Street Thug 1");
		familyMap.put(4, "TT Boss Street Thug 2");
		familyMap.put(5, "BT Boss Street Thug 1");
		//read in the matrix
		int[][] matrix = InputFileToMatrix();
		//test
//		for(int i = 0; i < matrix.length; i++) {
//			for (int x = 0; x < matrix.length; x++) {
//				System.out.print(Integer.toString(matrix[i][x]));
//			}
//		}
		
		int numberOfNodes = 6;
		boolean[] visited = {false, false, false, false, false, false};
		File outputFile = new File("C:\\Users\\charl\\eclipse-workspace\\DFSSearch\\outputFile.txt");
		System.out.println("Crime Bosses List:");
		DepthFirstSearch(matrix, visited, numberOfNodes, 0, familyMap, outputFile);

	}
	//allows writing to file
	private static void writeToFile(String comments, File file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.append(comments);
		writer.append("\n");
		writer.close();
		
	}
	//reads a [][] array from a file and puts it into a multidimensional array
    //returns int[][] array
	private static int[][] InputFileToMatrix() throws IOException {
		//create file to read
		File file =  new File("C:\\Users\\charl\\eclipse-workspace\\DFSSearch\\input.txt");
		Scanner scannerForLength = new Scanner(file);
		//find length of first line to establish the n x n matrix length
		String[] stringArrayFistLine = scannerForLength.nextLine().split("\\,");
		int lengthFirstLine = stringArrayFistLine.length;
		scannerForLength.close();
		Scanner scanner = new Scanner(file);
		//create matrix with proper dimensions
		int[][] subMatrix = new int[lengthFirstLine][lengthFirstLine];		
		int line = 0;  //counter for x 
		while(scanner.hasNextLine()) {
			//take commas out of line
			String[] inputLine = scanner.nextLine().split("\\,");
			//iterate over each line and put line (y) in current value of x
			for(int i = 0; i < inputLine.length; i++) {
				int stringToNumberConversion = Integer.parseInt(inputLine[i]);
				subMatrix[line][i] = stringToNumberConversion;
			}
			line++;
		}
		//close stream
		scanner.close();
		
		return subMatrix;
	}
	//DFS 
    //does a depth first search to the bottom of left side of the tree and continues to the right with repeat backtracking 
    //prints output to the screen and writes to file
	private static void DepthFirstSearch(int[][] matrix, boolean[] visited, int n, int i, HashMap<Integer, String> hashTable, File file) {
		try {
			writeToFile(hashTable.get(i).toString(), file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(hashTable.get(i).toString());
		visited[i]= true;
		for(int j = 0; j < n; j++) {
			if (!(visited[j]) && matrix[i][j] == 1) {
				DepthFirstSearch(matrix, visited, n, j, hashTable, file);
			}
		}
	}
}
