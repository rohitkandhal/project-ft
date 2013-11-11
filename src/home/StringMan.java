package home;

public class StringMan {

	/*/
	 * Input: "Hello World"
	 * Output: "dlroW olleH"
	 */
	public char[] reverseString(char[] inp, int lindex, int rindex)
	{
		char tmp;
		while(lindex < rindex)
		{
			tmp = inp[rindex];
			inp[rindex] = inp[lindex];
			inp[lindex] = tmp;
			rindex--;
			lindex++;
		}
		return inp;
	}
	
	/*/
	 * Input: "Hello World"
	 * Output: "olleH dlroW"
	 */
	public char[] reverseWords(String inpStr)
	{
		char[] inpChars = inpStr.toCharArray();
		int lindex = 0;
		int rindex = 0;
		for(rindex = 0; rindex <= inpStr.length(); rindex++)
		{
			// 1. Suppose we have only one word string "ABC" -> "CBA"
			// 2. Detect space "Hello World"
			if(rindex == inpStr.length() || inpChars[rindex] == ' ')
			{
				inpChars = reverseString(inpChars, lindex, rindex-1);
				lindex = rindex+1;
			}
		}
		return inpChars;
	}
}
