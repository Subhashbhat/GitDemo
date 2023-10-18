package file_io_practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class OccurrenceOfGivenStringUsingFilePath {

	public static void printOccurrenceOfGivenSrchString(String path, String srchStr) {

		if (path == null || path.trim().isEmpty())
			throw new IllegalArgumentException("Invalid path");
		if (srchStr == null || srchStr.trim().isEmpty())
			throw new IllegalArgumentException("Invalid Search String");

		File f = new File(path);
		if (f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
				int count = 0;
				String line;
				while ((line = br.readLine()) != null) {
					if (line.contains(srchStr)) {
						System.out.println(line);
						int pos = 0;
						while ((pos = line.indexOf(srchStr, pos)) != -1) {
							count++;
							pos++;
						}
					}
				}
				System.out.println("Number of Occurrence of Given Search String is : " + count);
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
		System.out.println("Enter a file path : ");
		String path = sc2.nextLine();
		System.out.println("Enter the search string : ");
		String searchString = sc1.nextLine();
		printOccurrenceOfGivenSrchString(path, searchString);
	}

}
