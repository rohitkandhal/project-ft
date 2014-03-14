package home;

public class Telephone {

	private static final int LENGTH = 7;
	
	private final int[] phoneNum = {3,4,5,6,7,8,9};
	private char[] result = new char[LENGTH];
	
	@SuppressWarnings("unused")
	private void printWords(int curDigit) {

		if(curDigit  == LENGTH)
		{
			System.out.println(new String(result));
			return;
		}
		
		for(int i = 1; i <= 3; i++)
		{
			result[curDigit] = getCharKey(phoneNum[curDigit], i);
			printWords(curDigit + 1);
			
			if(phoneNum[curDigit] == 0 || 
					phoneNum[curDigit] == 1)
				return;
		}
	}

	private char getCharKey(int telephoneKey, int place) {
		switch (telephoneKey) {
		case 2:
			switch (place) {
			case 1:
				return 'A';
			case 2:
				return 'B';
			case 3:
				return 'C';
			}
			break;

		case 3:
			switch (place) {
			case 1:
				return 'D';
			case 2:
				return 'E';
			case 3:
				return 'F';
			}
			break;

		case 4:
			switch (place) {
			case 1:
				return 'G';
			case 2:
				return 'H';
			case 3:
				return 'I';
			}
			break;

		case 5:
			switch (place) {
			case 1:
				return 'J';
			case 2:
				return 'K';
			case 3:
				return 'L';
			}
			break;

		case 6:
			switch (place) {
			case 1:
				return 'M';
			case 2:
				return 'N';
			case 3:
				return 'O';
			}
			break;

		case 7:
			switch (place) {
			case 1:
				return 'P';
			case 2:
				return 'R';
			case 3:
				return 'S';
			}
			break;

		case 8:
			switch (place) {
			case 1:
				return 'T';
			case 2:
				return 'U';
			case 3:
				return 'V';
			}
			break;

		case 9:
			switch (place) {
			case 1:
				return 'X';
			case 2:
				return 'Y';
			case 3:
				return 'Z';
			}
			break;
		}
		return ' ';
	}
}
