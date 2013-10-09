package home;

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
		
		System.out.println(int_str + "."+ dec_str);
		
		return int_str + "."+ dec_str;
	}
}
