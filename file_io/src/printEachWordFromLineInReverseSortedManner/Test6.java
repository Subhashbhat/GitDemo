package printEachWordFromLineInReverseSortedManner;

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

public class Test6 {

	public static void printEachWordInSortedReverseOrder(String path) {

		if (path == null) {
			throw new IllegalArgumentException("Invalid path");
		}
		File f = new File(path);
		if (f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			BufferedReader br = null;
			List<String> words = new ArrayList<String>();
			Set<String> sortedSet = new TreeSet<String>();
			Set<String> sortedReverseSet = new TreeSet<String>();
			String line;
			try {
				br = new BufferedReader(new FileReader(f));
				while ((line = br.readLine()) != null) {
					String[] str = line.split(" ");
					for (String s : str) {
						words.add(s);
						sortedSet.add(s);
					}
				}
				System.out.println("Unsorted List : "+words);
				Collections.sort(words);
				System.out.println("Sorted List : "+words);
				StringDescComparator s = new StringDescComparator();
				Collections.sort(words, s);
				System.out.println("Reversed List : "+words);
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
		printEachWordInSortedReverseOrder(path);
	}

}
