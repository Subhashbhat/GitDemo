//WAP to search for all occurrence of a given string, given a path(could be a folder too)
package SearchForAllOccurreceOfGivenString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test8 {

	public static void printNumOfOccurrencesOfEveryWordInFile(String path) {
		if (path == null) {
			throw new IllegalArgumentException("Invalid path");
		}
		File f = new File(path);
		if (f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
				Map<String, Integer> words = new HashMap<String, Integer>();
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					String[] str = line.split(" ");
					for (String s : str) {
						//int count = 1;
						if(words.get(s) != null) {
							words.put(s, words.get(s)+1);
						}else {
							words.put(s, 1);
						}
					}
				}
				System.out.println(words);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the file path : ");
		String path = sc2.nextLine();
		printNumOfOccurrencesOfEveryWordInFile(path);
	}

}
/*OutPut : 
Enter the file path : 
C:\subhash\file_io\src\SearchForAllOccurreceOfGivenString\Test8.txt
Hickory Dickory Dock
The mouse ran up the clock
The clock struck one
The The mouse ran down
Hickory Dickory Dock
{The=4, the=1, mouse=2, Dickory=2, Dock=2, one=1, struck=1, up=1, clock=2, down=1, ran=2, Hickory=2}
*/
