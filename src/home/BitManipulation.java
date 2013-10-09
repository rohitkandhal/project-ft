package home;

public class BitManipulation {
	
	/*/
	 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
	 * Write a method to set all bits between i and j in N equal to M 
	 * (e.g., M becomes a substring of N located at i and starting at j).
	 * EXAMPLE:
	 * Input: N = 10000000000, M = 10101, i = 2, j = 6
	 * Output: N = 10001010100
	 * 
	 *     N --- j --- i --- M
	 *     located at i - count from the right side
	 *     starting at j - count from the left side
	 */
	public void updateBits(int n, int m, int i, int j){
		
		int max = ~0;		// All 1
		
		int right =  (1 << i) - 1;
		
		int left = max - ((1<<j) - 1);
		
		int mask = left | right;
		
		int finalnum = (n & mask) | (m << i);
		
		System.out.println("N: " + Integer.toBinaryString(n));
		System.out.println("M: " + Integer.toBinaryString(m));
		System.out.println("Out: " + Integer.toBinaryString(finalnum));
	}

}
