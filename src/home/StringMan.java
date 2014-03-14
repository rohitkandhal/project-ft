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

	/*
	 * / Checks a palindrome string Input: "LeveL" Output: True
	 */
	public boolean isPalindrome(String inp) {
		char[] inpChars = inp.toCharArray();
		int start = 0, end = inp.length() - 1;

		while (start < end) {
			if (inpChars[start++] != inpChars[end--]) {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome(Integer inp) {
		// 12321
		int reverse = 0;
		int original = inp;

		while (inp > 0) {
			reverse = reverse * 10 + (inp%10);
			inp = inp / 10;
		}

		if (original == reverse) {
			return true;
		}
		return false;
	}

	/*
	 * Permutation of a string - recursive
	 */
	public void permutations(String inp) {
		permutationsInternal("", inp);
	}

	public void permutationsInternal(String prefix, String inpStr) {
		if (inpStr.length() == 0) {
			// The base case: input is an empty string the only permutation is
			// the empty string + Prefix
			System.out.print(prefix + ", ");
		} else {
			// Try each of the letters in turn as the first letter and
			// then find all the permutations of the remaining letters using a
			// recursive call.
			for (int i = 0; i < inpStr.length(); i++) {
				permutationsInternal(
						prefix + inpStr.charAt(i),
						inpStr.substring(0, i)
								+ inpStr.substring(i + 1, inpStr.length()));
			}
		}
	}

	public void testStringPermutations() {
		String testString = "rohit";
		System.out.println(testString);
		permutations(testString);
	}

	/*
	 * Finds a unique number between an array from 1 to n with one number
	 * missing Handles Integer overflow Logic: first xor from start to max then
	 * xor the final result with each number in array. XOR of an element with
	 * itself is 0 i.e. x ^ x = 0
	 */
	public void findUniqueIntInArray(int[] inp, int max) {
		int xor = 0;
		for (int i = 1; i <= max; i++) {
			xor ^= i;
		}

		for (int i : inp) {
			xor ^= i;
		}

		System.out.println(xor);
	}

	public void testFindUnique() {
		// Input: 5,4,3,2
		// Output: 1
		int[] arr = { 5, 4, 3, 2 };
		int maxNumberInArray = 5;
		this.findUniqueIntInArray(arr, maxNumberInArray);

	}

}
