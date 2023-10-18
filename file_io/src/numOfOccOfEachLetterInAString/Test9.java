package numOfOccOfEachLetterInAString;

public class Test9 {
	
	public static void printOccOfEachLetterInAString(String str) {
		
		int[] arr = new int[26];
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			arr[c - 'a']++;
		}
		for(int i = 0; i < arr.length; i++) {
			//if(arr[i] != 0)
			System.out.println((char)(i+'a')+" occurrs : "+arr[i]);
		}
	}
	
	public static void main(String[] args) {
		
		printOccOfEachLetterInAString("hickorydickorydock");
	}

}
