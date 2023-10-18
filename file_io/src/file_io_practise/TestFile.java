package file_io_practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestFile {

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter a path : ");
		String path = sc1.nextLine();
		System.out.println("Enter a word to search : ");
		String srchString = sc2.nextLine();
		File f = new File(path);
		System.out.println("f.exists()->" + f.exists());
		System.out.println("f.isFile->" + f.isFile());
		System.out.println("f.isDirectory->" + f.isDirectory());
		System.out.println("f.getName()->" + f.getName());
		System.out.println("f.getName()->" + f.getPath());
		System.out.println("f.getAbsoluteFile()->" + f.getAbsoluteFile());// gives absolute path
		System.out.println("f.length()->" + f.length());// gives in bytes
		System.out.println("f.canRead()->" + f.canRead());
		System.out.println("---------------------------------------------");
		if (f.exists() && f.isDirectory()) {
			File[] fa = f.listFiles();// .listFiles() gives array of file
			int count = 0;
			for (File fi : fa) {
				// Given a path, tell me how to find out if it is pointing to a text file :
				/*
				 * 1.get the path as a input from the user 2.create a file object 3.check if it
				 * exists and if it a file and get the name and check if it ends with .txt
				 */
				if (fi.exists() && fi.isFile() && fi.getName().endsWith(".txt")) {
					System.out.println("--------------------------------txt match found");
					// to check number of occurrence of a given word
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(fi));
						String line;
						//int count = 0;
						while ((line = br.readLine()) != null) {
							int pos = 0;
							while ((pos = line.indexOf(srchString, pos)) != -1) {
								count++;
								pos++;
							}
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						//System.out.println("Number of occurrence of given string is : " + count);
						try {
							if (br != null)
								br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				System.out.println("f.getName()->" + fi.getName());
				System.out.println("f.exists()->" + fi.exists());
				System.out.println("f.isFile->" + fi.isFile());
				System.out.println("f.isDirectory->" + fi.isDirectory());
				System.out.println("f.getAbsoluteFile()->" + fi.getAbsoluteFile());
				System.out.println("f.length()->" + fi.length());
				System.out.println("f.canRead()->" + fi.canRead());
			}
			System.out.println("Number of occurrence of given string is : " + count);
		}

		// Given a path, tell me how to find out if it is pointing to a text file :
		/*
		 * 1.get the path as a input from the user 2.create a file object 3.check if it
		 * exists and if it a file and get the name and check if it ends with .txt
		 */

	}

}
