package home;

public class StringComparison {

	public static void main(String args[]){
		StringComparison strComp = new StringComparison();
		System.out.println("Case 1: String 1 < String 2");
		strComp.testStringComparison("abcdef", "uvwxyz");
		System.out.println("Case 2: String 1 = String 2");
		strComp.testStringComparison("abcdef", "abcdef");
		System.out.println("Case 3: String 1 > String 2");
		strComp.testStringComparison("uvwxyz", "abcdef");
	}
	/*
	 * Assuming that two input strings are of same length otherwise need input
	 * on how to display merged string?
	 */
	public void testStringComparison(String a, String b) {

		if (a.length() > Integer.MAX_VALUE || b.length() > Integer.MAX_VALUE) {
			System.out.println("Strings max length");
		} else {
			System.out.print("Input: ");
			System.out.print(a + ", ");
			System.out.println(b);

			int comparison = myStrCmp(a, b);

			if (comparison < 0) {
				// Display inverted strings
				System.out.println("Output: " + reverseString(a) + ", "
						+ reverseString(b));
			} else if (comparison > 0) {
				System.out.println("Output: "
						+ this.mergeString(reverseString(a), reverseString(b)));
			} else {
				System.out.println("Output: " + this.mergeString(a, b));
			}
		}
	}

	/*
	 * String Comparison Function returns 0 if input strings are same returns <0
	 * if string1 is less than string2 returns >0 if string1 is greater than
	 * string 2
	 */
	public int myStrCmp(String a, String b) {

		// Convert String to Char Array
		char a1[] = this.myStrToCharArray(a);
		char b1[] = this.myStrToCharArray(b);

		// Find minimum of two lengths
		int len1 = a1.length;
		int len2 = b1.length;
		int min = Math.min(len1, len2);

		// Compare two char arrays
		int index = 0;

		while (index < min) {
			char achar = a1[index];
			char bchar = b1[index];
			if (achar != bchar) {
				return achar - bchar;
			}
			index++;
		}

		return len1 - len2;
	}

	/*
	 * Converts a string to char array
	 */
	public char[] myStrToCharArray(String s) {
		if (s == null) {
			return null;
		}
		char[] charArray = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			charArray[i] = s.charAt(i);
		}
		return charArray;
	}

	/*
	 * Reverses a string
	 */
	public String reverseString(String s) {
		if (s == null) {
			return null;
		}

		char[] charArray = myStrToCharArray(s);
		int start = 0;
		int end = charArray.length - 1;

		char tmp;
		while (start < end) {
			tmp = charArray[start];
			charArray[start++] = charArray[end];
			charArray[end--] = tmp;
		}
		return String.valueOf(charArray);
	}

	/*
	 * Assumption: Both strings are of same length
	 */
	public String mergeString(String a, String b) {
		if (a == null && b == null) {
			return null;
		}

		if (a.length() != b.length()) {
			return null;
		}

		char[] outputString = new char[a.length() + b.length()];

		char[] aCharArray = this.myStrToCharArray(a);
		char[] bCharArray = this.myStrToCharArray(b);
		int stringIndex = 0;
		for (int i = 0; i < a.length(); i++) {
			outputString[stringIndex++] = aCharArray[i];
			outputString[stringIndex++] = bCharArray[i];
		}

		return String.valueOf(outputString);
	}
}
