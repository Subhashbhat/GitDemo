/*WAP to print number of occurrence of given string in a given path file*/
package printNumberOfOccurrenceOfGivenStr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Test4 {

	public static void printTextFileContentsWithOccurrenceOfSrchString(String path, String srchStr) {
		if (path == null) {
			throw new IllegalArgumentException("Path is not valid");
		}
		File f = new File(path);
		if (f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			LineNumberReader br = null;
			try {
				br = new LineNumberReader(new BufferedReader(new FileReader(f)));
				String line;
				int count = 0;
				while ((line = br.readLine()) != null) {
					if (line.contains(srchStr)) {
						System.out.println("No: " + br.getLineNumber() + " : " + line);
						int pos = 0;
						while((pos = line.indexOf(srchStr, pos)) != -1) {
							count++;
							pos++;
						}
					}
				}
				System.out.println("No of occ : "+count);
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
		System.out.println("Enter a file path");
		String path = sc2.nextLine();
		System.out.println("Enter a string to search");
		String srchString = sc1.next();
		printTextFileContentsWithOccurrenceOfSrchString(path, srchString);

	}
}
