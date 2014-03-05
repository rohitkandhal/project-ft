package home;

import java.util.ArrayList;

public class Recursion {

	public ArrayList<ArrayList<Integer>> GetSubsetCollection(
			ArrayList<Integer> inputSet) {
		return this.GetSubsetCollection(inputSet, inputSet.size());
	}

	private ArrayList<ArrayList<Integer>> GetSubsetCollection(
			ArrayList<Integer> inputSet, int currentIndex) {
		ArrayList<ArrayList<Integer>> resultSet;

		if (currentIndex == 0) {
			resultSet = new ArrayList<ArrayList<Integer>>();

			ArrayList<Integer> emptyList = new ArrayList<Integer>();
			resultSet.add(emptyList);
		} else {
			resultSet = GetSubsetCollection(inputSet, currentIndex - 1);

			int currInt = inputSet.get(currentIndex - 1);

			ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> currSetElement : resultSet) {
				// Add current element to All previous subsets
				ArrayList<Integer> newElements = new ArrayList<Integer>();
				newElements.addAll(currSetElement);
				newElements.add(currInt);

				newSubsets.add(newElements);
			}
			resultSet.addAll(newSubsets);
		}
		return resultSet;

	}
	
	public void printSubsetCollection(ArrayList<ArrayList<Integer>> subsets) {
		for (ArrayList<Integer> subsetElements : subsets) {
			System.out.println();
			for (Integer currChar : subsetElements) {
				System.out.print(currChar + ", ");
			}
		}
	}
	
	

	public void printInvertedTriangle() {
		for (int i = 0; i < 3; i++) {

			System.out.println();
			for (int j = 0; j < 3; j++) {
				if (j < i) {
					System.out.print("-");
				} else {
					System.out.print("*");
				}
			}
		}
	}

	int[] dictionary;

	public int getFibWithMem(int n) {
		if (dictionary == null) {
			dictionary = new int[n];
		}
		
		if (dictionary[n - 1] == 0) {
			if (n <= 2) {
				dictionary[n - 1] = n - 1;
			} else {
				dictionary[n - 1] = getFibWithMem(n - 1) + getFibWithMem(n - 2);
			}
		}

		return dictionary[n - 1];
	}

	public void printFibonacci() {
		int i = 0;
		for (int curr : dictionary) {
			System.out.print("F[" + i++ + "]:" + curr + ", ");
		}
	}
}
