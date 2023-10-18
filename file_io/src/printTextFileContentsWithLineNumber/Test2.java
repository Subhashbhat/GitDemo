package printTextFileContentsWithLineNumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Test2 {
	
	public static void printTextFileContentsWithLineNumbers(String path) {
		if (path == null) {
			throw new IllegalArgumentException("Path is not valid");
		}
		File f = new File(path);
		if (f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			LineNumberReader br = null;
			try {
				br = new LineNumberReader(new BufferedReader(new FileReader(f)));
				String line;
				while((line = br.readLine()) != null) {
					System.out.println("No: "+br.getLineNumber()+" : "+line);
				}
				/*BufferedReader br = null;
				 * int lineNumber = 0;
			     try {
					br = new BufferedReader(new FileReader(f));
					String line;
					while((line = br.readLine()) != null) {
					lineNumber++;
						System.out.println("No: "+lineNumber+" : "+line);
				  }*/
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				if(br != null) {
					try {
						br.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter path of a file : ");
		String path = sc1.nextLine();
		printTextFileContentsWithLineNumbers(path);
	}

}
