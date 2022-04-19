 /*
  * Class: CMSC203 CRN 3416
 Program: Assignment #4
 Instructor: Dr. Grinberg
 Summary of Description: utility class that manipulates a two-dimensional ragged array of doubles. 
 This utility class will be used to create a Sales Report for Retail District #5
 Due Date: 04/18/22
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 William Tiwari
  */


public class HolidayBonus {
/*
 * use nested for loops and if statements to create an array of doubles that is returned 
 */
	public static double[] calculateHolidayBonus(double[][] data, double highestSalesBonus, double lowestSalesBonus, double otherStoreBonus) {
	    double[] holidayBonus = new double[data.length];
	    for (int row = 0; row<data.length; row++){
	      for (int col = 0; col<data[row].length; col++){
	        
	    	  if(data[row][col]>0) {
	    		  if(data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data,col) ) {
	    			  holidayBonus[row] += highestSalesBonus;
	    		  }else if (data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data,col)) {
	    			  holidayBonus[row] += lowestSalesBonus;
	    		  }else {
	    			  holidayBonus[row] += otherStoreBonus;
	    		  }
	    	  }
	      }
	    }
	    return holidayBonus; 
	  }
/*
 * call calculateTotalHolidayBonus to calculate bonuses and for loop to add all of the bonuses together 
 */
	 public static double calculateTotalHolidayBonus(double[][] data, double highestSalesBonus, double lowestSalesBonus, double otherStoreBonus) {
		    int total = 0;
		    double[] bonuses = calculateHolidayBonus(data, highestSalesBonus, lowestSalesBonus, otherStoreBonus);
		    for(int i = 0; i < bonuses.length; i++){
		      total += bonuses[i];
		    }
		    return total;
		  }
		     
	
}
