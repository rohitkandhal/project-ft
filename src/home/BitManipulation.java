package home;

import java.util.ArrayList;
import java.util.HashMap;

public class BitManipulation {

	/*
	 * / You are given two 32-bit numbers, N and M, and two bit positions, i and
	 * j. Write a method to set all bits between i and j in N equal to M (e.g.,
	 * M becomes a substring of N located at i and starting at j). EXAMPLE:
	 * Input: N = 10000000000, M = 10101, i = 2, j = 6 Output: N = 10001010100
	 * 
	 * N --- j --- i --- M located at i - count from the right side starting at
	 * j - count from the left side
	 */
	public void updateBits(int n, int m, int i, int j) {

		int max = ~0; // All 1

		int right = (1 << i) - 1;

		int left = max - ((1 << j) - 1);

		int mask = left | right;

		int finalnum = (n & mask) | (m << i);

		System.out.println("N: " + Integer.toBinaryString(n));
		System.out.println("M: " + Integer.toBinaryString(m));
		System.out.println("Out: " + Integer.toBinaryString(finalnum));
	}

	/*
	 * / Converts a string having double number to binary
	 */
	public String doubleToBinary(String str) {
		int int_part = Integer.parseInt(str.substring(0, str.indexOf('.')));

		double dec_part = Double.parseDouble(str.substring(str.indexOf('.'),
				str.length()));

		// Integer to binary
		String int_str = "";

		while (int_part > 0) {
			int temp = int_part % 2;

			int_str = temp + int_str;

			int_part >>= 1; // Divide by 2
		}

		// Decimal to binary
		StringBuilder dec_str = new StringBuilder();

		while (dec_part > 0) {

			if (dec_str.length() > 32) {
				break;
			}

			if (dec_part == 1) {
				dec_str.append(1);
				break;
			}

			double temp = dec_part * 2;

			if (temp >= 1) {
				dec_str.append(1);
				dec_part = temp - 1;
			} else {
				dec_str.append(0);
				dec_part = temp;
			}
		}

		System.out.println(int_str + "." + dec_str);

		return int_str + "." + dec_str;
	}

	/*
	 * / Input Output 25 22 35 28 Returns next smallest number with same number
	 * of 1 bits
	 */
	public int nextSmallestNumber(int n) {

		System.out.println("Input: " + Integer.toBinaryString(n) + " (" + n
				+ ")");

		if (n <= 0)
			return -1;

		int index = 0;
		int countOnes = 0;

		// First first zero
		while (GetBit(n, index)) {
			index++;
			countOnes++;
		}

		// Find next one
		while (!GetBit(n, index)) {
			index++;
		}

		// Turn this one to zero
		n = setBit(n, index, false);

		// Turn last 0 to one
		index--;
		n = setBit(n, index, true);

		index--;
		// move all ones here
		while (countOnes > 0) {
			n = setBit(n, index, true);
			index--;
			countOnes--;
		}

		// set all remaining bits to 0
		while (index >= 0) {
			n = setBit(n, index, false);
			index--;
		}

		System.out.println("Output :" + Integer.toBinaryString(n) + " (" + n
				+ ")");
		return n;

	}

	public boolean GetBit(int n, int index) {
		return ((n & (1 << index)) > 0);
	}

	/*
	 * / Sets bit at index <i> to either 1 or 0 depending on Boolean b in
	 * integer n
	 */
	public int setBit(int n, int index, boolean b) {

		if (b) {
			// Set bit at index to 1
			return n | (1 << index);
		} else {
			// Set bit at index to 0
			int mask = ~(1 << index);
			return n & mask;
		}

	}

	public class Result {
		int hits;
		int pseudoHits;
	}

	/*
	 * / Input: Solution: "RGGB", Guess: "YRGB"
	 * 
	 * Output: Hits: 2 (GB), Pseudo Hits: 1 (R)
	 */
	public void getEstimate(String guess, String solution) {
		Result result = new Result();

		int solution_mask = 0;

		for (int i = 0; i < 4; ++i) {
			solution_mask |= 1 << (1 + solution.charAt(i) - 'A');
		}

		for (int i = 0; i < 4; i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				result.hits++;
			} else if ((solution_mask & (1 << (1 + guess.charAt(i) - 'A'))) >= 1) {
				result.pseudoHits++;
			}
		}

		System.out.println("Hits: " + result.hits + " \nPseudo Hits: "
				+ result.pseudoHits);
	}

	public void getSimilarityCount(String original, String newValue) {
		Result result = new Result();

		int solution_mask = 0;

		for (int i = 0; i < original.length(); i++) {
			solution_mask |= 1 << (original.charAt(i));
		}
		
		for (int i =0; i < newValue.length(); i++)
		{
			//System.out.println((int)original.charAt(i));
			if((solution_mask & (1 << (int)newValue.charAt(i))) >= 1)
			{
				result.pseudoHits++;
			}
		}
		
		System.out.println("Number of common characters in two strings: " + result.pseudoHits);

	}
}
