package iddfs;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 
public class IterativeDeepening
{
	private static int[][] adjacencyMatrix;
    private static int numberOfNodes;
    private static int currentDepth;

    
    //IDS 
    //determines the levels of depth being done by each iteration of the depthLimitedSearch method
    //writes levels heading to file
    public static void iterativeDeeping(int maxDepth, int startingnode, File outputFile) throws IOException {
    	numberOfNodes = adjacencyMatrix[0].length;
    	//System.out.println(Integer.toString(numberOfNodes));  //test
    	for (int i = 1; i < 4; i++) {
    		int[] visited = new int[numberOfNodes];
    		int depth = 0;
    		//build label for different levels
    		StringBuilder depthHeadingBuilder = new StringBuilder();
    		depthHeadingBuilder.append("Depth at level: ");
    		depthHeadingBuilder.append(Integer.toString(i - 1));
    		String depthHeadingString = depthHeadingBuilder.toString();
    		System.out.println(depthHeadingString);
    		writeToFile(depthHeadingString , outputFile);  //file write
    		//call dfs with level determined by for loop variable i
    		depthLimitedSearch(i, startingnode, depth, visited, outputFile);
    	}
    }
    //DFS 
    //does a depth first search for the depth of the level passed by the IDS 
    //prints output to the screen and writes to file
    private static void depthLimitedSearch(int limit, int node, int depth, int[] visited, File outputFile) throws IOException{
		if(depth < limit) {
			writeToFile(Integer.toString(node) , outputFile);
			System.out.println(Integer.toString(node));
			visited[node]= 1;
			for(int j = 0; j < numberOfNodes; j++) {
				if ((visited[j] != 1) && adjacencyMatrix[node][j] == 1) {
					depthLimitedSearch(limit, j, depth + 1, visited, outputFile);
				}
			}
		}
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
 
    public static void main(String... arg) throws IOException{
    	int startingNode = 0;
    	int maxDepth = 3;
    	adjacencyMatrix = InputFileToMatrix();
    	//establishes file for output
    	File outputFile = new File("C:\\users\\charl\\eclipse-workspace\\Searches\\src\\dfs\\outputFile2.txt");
        iterativeDeeping(maxDepth, startingNode, outputFile);
        
    }
}