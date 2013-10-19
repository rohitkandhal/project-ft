package home;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args)
	{
		//System.out.println("Hello World");
		
		// BitManipulation bitman = new BitManipulation();
		// bitman.updateBits(1024, 21, 2, 6);
		// bitman.doubleToBinary("32768.0");
		// bitman.nextSmallestNumber(35);
		
		// Recursion Problems
		Recursion recursion = new Recursion();
		ArrayList<Integer> inputSet = new ArrayList<Integer>();
		inputSet.add(1);
		inputSet.add(2);
		inputSet.add(3);
		ArrayList<ArrayList<Integer>> outputSet;
		outputSet = recursion.GetSubsetCollection(inputSet);
		recursion.printSubsetCollection(outputSet);
		
	}

}
