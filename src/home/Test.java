package home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	private int nameId;
	private String user;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nameId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Test)) {
			return false;
		}
		Test other = (Test) obj;
		if (nameId != other.nameId) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		// System.out.println("Hello World");

		// BitManipulation bitman = new BitManipulation();
		// bitman.updateBits(1024, 21, 2, 6);
		// bitman.doubleToBinary("32768.0");
		// bitman.nextSmallestNumber(35);
		// bitman.getEstimate("YRGB", "RGGB");
		// bitman.getSimilarityCount("Rohit", "MOHIT");

		// Recursion Problems

		 // Recursion recursion = new Recursion();
		// ArrayList<Integer> inputSet = new ArrayList<Integer>();
		// inputSet.add(1);
		// inputSet.add(2);
		// inputSet.add(3);
		// ArrayList<ArrayList<Integer>> outputSet;
		// outputSet = recursion.GetSubsetCollection(inputSet);
		// recursion.printSubsetCollection(outputSet);

		// recursion.printInvertedTriangle();
		 
		 // recursion.getFibWithMem(20);
		 // recursion.printFibonacci();
		 
		//Test t1 = new Test();
		//t1.regexTest();
		
		 StringMan stringMan = new StringMan();
		 String testString = "Hello World";
		 System.out.println(testString);
		 System.out.println(stringMan.reverseString(testString.toCharArray(), 0, (testString.length() - 1)));
		 System.out.println(stringMan.reverseWords(testString));
		
	}

	public void testHarness() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			System.out.println("hello world");
		}
	}

	public void regexTest() {
		
		Pattern p = Pattern.compile("Foo"); 
		Matcher m = p.matcher("FooGooFooooHelloFootestingfoo");
		while (m.find()) {
			System.out.println(m.start() + ", " + m.end() + ", " + m.group());
		}
	}
}
