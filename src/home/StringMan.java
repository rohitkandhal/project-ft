package home;

public class StringMan {

	/*
	 * / Input: "Hello World" Output: "dlroW olleH"
	 */
	public char[] reverseString(char[] inp, int lindex, int rindex) {
		char tmp;
		while (lindex < rindex) {
			tmp = inp[rindex];
			inp[rindex] = inp[lindex];
			inp[lindex] = tmp;
			rindex--;
			lindex++;
		}
		return inp;
	}

	/*
	 * / Input: "Hello World" Output: "olleH dlroW"
	 */
	public char[] reverseWords(String inpStr) {
		char[] inpChars = inpStr.toCharArray();
		int lindex = 0;
		int rindex = 0;
		// Note: Loop runs 1 extra time. It's rindex <= length not <
		for (rindex = 0; rindex <= inpStr.length(); rindex++) {
			// 1. Suppose we have only one word string "ABC" -> "CBA"
			// 2. Detect space "Hello World"
			// Imp: Both checks should be in this order only
			if (rindex == inpStr.length() || inpChars[rindex] == ' ') {
				inpChars = reverseString(inpChars, lindex, rindex - 1);
				lindex = rindex + 1;
			}
		}
		return inpChars;
	}

	/*/
	 * Checks a palindrome string
	 * Input: "LeveL"
	 * Output: True
	 */
	public boolean isPalindrome(String inp) {
		char[] inpChars = inp.toCharArray();
		int start = 0, end = inp.length()-1;

		while (start < end) {
			if (inpChars[start++] != inpChars[end--]) {
				return false;
			}
		}
		return true;
	}
}
