

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSet1 = {{10,20,30},{40,50},{60,70,80}};
	private double[][] dataSet2 = {{70,20,90,40},{50},{80,10,30},{110,60,70,20}};
	private double[][] dataSet3 = {{72,25,93},{59},{81,17,33},{116,69,73,27}};
	//dataSet3 has fewer elements in first row than in other rows
	private double[][] dataSet4 = {{-25,-53,61},{-44,82},{23,-75},{-42,73,-59,26}};
	//dataSet4 has negative elements as well as positive
	private double[][] dataSetSTUDENT = null;
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(360.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
		assertEquals(650.0,TwoDimRaggedArrayUtility.getTotal(dataSet2),.001);
		assertEquals(665,TwoDimRaggedArrayUtility.getTotal(dataSet3),.001);
		assertEquals(-33,TwoDimRaggedArrayUtility.getTotal(dataSet4),.001);
		//fail("Student testGetTotal not implemented");	
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
			assertEquals(45,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
			assertEquals(54.167,TwoDimRaggedArrayUtility.getAverage(dataSet2),.001);
			assertEquals(60.455,TwoDimRaggedArrayUtility.getAverage(dataSet3),.001);
			assertEquals(-3,TwoDimRaggedArrayUtility.getAverage(dataSet4),.001);
		//fail("Student testGetAverage not implemented");	
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(90.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
		assertEquals(50.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,1),.001);
		assertEquals(220.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,0),.001);
		assertEquals(285.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,3),.001);
		assertEquals(59.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,1),.001);
	//fail("Student testGetRowTotal not implemented");	
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(110.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,0),.001);
		assertEquals(190.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2,2),.001);
		assertEquals(111,TwoDimRaggedArrayUtility.getColumnTotal(dataSet3,1),.001);
		//fail("Student testGetColumnTotal not implemented");	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(80.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
		assertEquals(110.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet2),.001);
		assertEquals(116,TwoDimRaggedArrayUtility.getHighestInArray(dataSet3),.001);
		//fail("Student testGetHighestInArray not implemented");	
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSet4, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(-25, array[0][0],.001);
		assertEquals(-53, array[0][1],.001);
		assertEquals(61, array[0][2],.001);
	}

}
