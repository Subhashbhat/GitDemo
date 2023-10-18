/*WAP to read a file that contains one word per line and display it in sorted manner*/
package contains1WordPerLineAndDisplayItInSortedManner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test5 {
	
	public static void printEachWordInSortedOrder(String path) {
		
		if(path == null) {
			throw new IllegalArgumentException("Invalid path");
		}
		File f = new File(path);
		if(f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			BufferedReader br = null;
			List<String> words = new ArrayList<String>();
			Set<String> sortedSet = new TreeSet<String>();
			Set<String> sortedReverseSet = new TreeSet<String>();
			String line;
			try {
				br = new BufferedReader(new FileReader(f));
				while((line = br.readLine()) != null) {
					String[] str = line.split(" ");
					for(String s : str) {
						words.add(s);
						sortedSet.add(s);
					}
				}
				Collections.sort(words);
				System.out.println("List with duplicates and sorted explicitly : ");
				System.out.println(words);
				System.out.println("Sorted set without duplicates and sorted implicitly : ");
				System.out.println(sortedSet);
				
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				if(br != null) {
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
		printEachWordInSortedOrder(path);
	}

}
