 /*
  * Class: CMSC203 CRN 3416
 Program: Assignment #4
 Instructor: Dr. Grinberg
 Summary of Description: utility class that manipulates a two-dimensional ragged array of doubles. 
 This utility class will be used to create a Sales Report for Retail District #5
 Due Date: 04/18/22
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 William Tiwari*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	
	public static double[][] readFile(File file) throws FileNotFoundException {
		
		String line;
		double ragged[][];
		int rows= 0, i =0;
		Scanner key = new Scanner(file);
		Scanner key2 = new Scanner(file);
		Scanner key3 = new Scanner(file);
		/*use a while loop to loop through the file to find how many rows there are 
		 * and increment a counter for it with every iteration 
		 */
		while(key.hasNextLine()) {
			rows++;
			key.nextLine();
		}
		//assign number of rows to the 2D array
		ragged = new double[rows][];
	
		/*
		 * use another while loop to iterate through the file and then read each line into a
		 * string variable that will be trimmed and tokenized(split) 
		 * each time the loop iterates we will use a counter(i) to itterate through the rows
		 * and assign the length of the string to be each rows column
		 */
		while(key2.hasNextLine()) {
			line = key2.nextLine();
			
			ragged[i] = new double[line.trim().split(" ").length];
			i++;
			
		}
		/*
		 * nested for loops to read in values from text document into the new ragged 
		 * array
		 */
		for(int j=0;j<ragged.length;j++) {
			for (int k=0; k<ragged[j].length; k++) {
				ragged[j][k] = key3.nextDouble();
				System.out.print(ragged[j][k] + " ");
			}
			System.out.println( " ");
			
		}

		return ragged;
	}
	
	static void writeToFile(double[][] ragged, File file) throws IOException{
		/*
		 * method uses a for nested for loop and a printWriter object to write the data passed 
		 * to it into a file from a ragged 2D array
		 */
		FileWriter f = new FileWriter(file);
		for (int i = 0; i < ragged.length; i++) {
			for (int j = 0; j < ragged[i].length; j++) {
				f.write(ragged[i][j] + " ");
			}
			f.write("\n");
		}

		// Close
		f.close();
	}
	
	static double getAverage(double[][] ragged) {
		/*
		 * method uses nested for loop to iterate through ragged array and adds them to sum
		 * and then divides it by the count which is incremented with each iteration 
		 */
		int count = 0;
		double sum = 0;
		
		for (int row = 0; row < ragged.length; row++) {
			for (int col = 0; col < ragged[row].length; col++) {
				sum += ragged[row][col];
				count++;
			}
		}

		return sum / count;
	}
	/*
	 * method uses a for loop and an index for the column to iterate throough the array
	 * and then an if statement to check that the column is within bounds. If so all of the 
	 * numbers contained within column are added together and returned 
	 */
	static double getColumnTotal(double[][] ragged, int col) {
		// Variables
		double total = 0;
		for(int row = 0; row < ragged.length; row++ ) {
		if (!(col >= ragged[row].length || col < 0)) {
				total+= ragged[row][col];
			}
		}
		return total;
	}
	/*
	 * method uses nested for loops to iterate through the array, storing its value 
	 * in a temp variable, then an if statement checks if it is greater than the value stored in highest 
	 *  if it is the value is stored in hohgest. finally, highest is returned.
	 */
	static double getHighestInArray(double[][] ragged) {
		double highest=0, temp=0;
		
		for(int row = 0; row < ragged.length; row++) {
			for(int col = 0; col<ragged[row].length; col++) {
				temp = ragged[row][col];
				if(temp>highest) {
					highest=temp;
				}
			}
		}
		return highest;
	}
	/*
	 * method uses nested for loops to iterate through the array, storing the value of a certain row and column 
	 * in a temp variable, then an if statement checks if it is greater than the value stored in highest 
	 *  if it is the value is stored in hohgest. finally, highest is returned.
	 */
	static double	getHighestInColumn(double[][] ragged, int col) {
		double highest=0, temp=0;
		for(int row = 0; row < ragged.length; row++) {
			if (!(col >= ragged[row].length||col<0)) {
					temp =ragged[row][col];
					if(temp>highest) {
						highest=temp;
					}
				}
			}
		return highest; 
	}
	/*
	 * method uses nested for loops to iterate through the array, storing the value of a certain row and column 
	 * in a temp variable, then an if statement checks if it is greater than the value stored in highest 
	 *  if it is the value is stored in hohgest. finally, the index of the highest in column is returned.
	 */
	static int getHighestInColumnIndex(double[][] ragged, int col) {
		double highest = 0, temp=0;
		int index=0;
		for(int row = 0; row<ragged.length; row++) {
			if (!(col >= ragged[row].length||col < 0)) {
				temp =ragged[row][col];
				if(temp>highest) {
					highest=temp;
					index=row;
					}
				}
			}
		return index;
	}
	
	static double getHighestInRow(double[][] ragged, int row) {
		double highest = 0, temp=0;
		if(row>ragged.length||row<0) {
			return 1;
		}else {
			for(int i=0; i<ragged[row].length; i++) {
				temp=ragged[row][i];
				if(temp>highest) {
					highest=temp;
				}
			}
		}
		return highest;
	}
	
	static int getHighestInRowIndex(double[][] ragged, int row) {
		int index=0;
		double highest=0, temp=0;
		
		if(row > ragged.length||row < 0) {
			return 0;
		}else{
			for (int i = 0; i < ragged[row].length; i++) {
				temp = ragged[row][i];
				if (temp>highest) {
					highest = temp;
					index = i;
				}
			}
		}
		return index;
	}
	/*
	 * method uses nested for loops to iterate through the array, storing its value 
	 * in a temp variable, then an if statement checks if it is less than the value stored in lowest 
	 *  if it is the value is stored in lowest. finally, lowest is returned.
	 */
	static double getLowestInArray(double[][] ragged) {
		double lowest = 0;
		for(int row = 0; row < ragged.length; row++) {
			for(int col = 0; col<ragged[row].length; col++) {
				if(lowest==0 || lowest > ragged[row][col]) {
					lowest=ragged[row][col];
				}
			}
		}
		return lowest;
	}
	/*
	 * method uses nested for loops to iterate through the array, storing the value of a certain row and column 
	 * in a temp variable, then an if statement checks if it is greater than the value stored in highest 
	 *  if it is the value is stored in hohgest. finally, highest is returned.
	 *  repeat same logic for the other getters bellow.
	 */
	static double getLowestInColumn(double[][] ragged, int col) {
		double lowest=0;
		for(int row = 0; row<ragged.length; row++) {
			if (!(col >= ragged[row].length||col < 0)) {
				if(lowest==0||ragged[row][col]<lowest) {
					lowest=ragged[row][col];
					}
				}
			}
		return lowest; 
	}
	
	static double getLowestInRow(double[][] ragged, int row) {
		double lowest = 0, temp=0;
		if(row>ragged.length||row<0) {
			return 1;
		}else {
			for(int i=0; i<ragged[row].length; i++) {
				temp=ragged[row][i];
				if(lowest==0||temp<lowest) {
					lowest=temp;
				}
			}
		}
		return lowest;
	}
	static int getLowestInColumnIndex(double[][] ragged, int col) {
		double lowest = 0, temp=0;
		int index=0;
		for(int row = 0; row<ragged.length; row++) {
			if (!(col >= ragged[row].length||col < 0)) {
				if(lowest==0||ragged[row][col]<lowest) {
					lowest=ragged[row][col];
					index=row;
					}
				}
			}
		return index;
	}
	
	static int getLowestInRowIndex(double[][] ragged, int row) {
		int index=0;
		double lowest=0, temp=0;
		if(row>ragged.length||row<0) {
			return 1;
		}else {
			for(int i=0; i<ragged[row].length; i++) {
				temp=ragged[row][i];
				if(lowest==0||temp<lowest) {
					lowest=temp;
					index = i;
				}
			}
		}
		return index;
	}
	/*
	 * Method uses a for loop to iterate through the aray and counts all entries into 
	 * rowTotal
	 */
	static double getRowTotal(double[][] ragged, int row) {
		double rowTotal = 0;
		if(row>ragged.length||row<0) {
			return 0;
		}else {
			for (int i = 0; i < ragged[row].length; i++) {
				rowTotal += ragged[row][i];
			}
		}
		
		return rowTotal;
	}
	/*
	 * Method uses nested for loops 
	 */
	static double getTotal(double[][] ragged) {
		double total = 0;
		for (int row = 0; row < ragged.length; row++) {
			for (int col = 0; col < ragged[row].length; col++) {
				total += ragged[row][col];
			}
		}

		// Return
		return total;
	}
	
	
	
}
