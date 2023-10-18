package file_io_practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrintContentsOfGivenFilePath {

	public static void printAllContentOfFile(String path) {

		if (path == null) {
			throw new IllegalArgumentException("Invalid path");
		}
		File f = new File(path);
		if (f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
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
		printAllContentOfFile(path);
	}

}
