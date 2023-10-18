package file_io_practise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class PrintFileContentWithLineNumber {
	
	public static void printAllFileContentsWithLineNumber(String path, String srchStr) {
		
		if (path == null || path.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid path");
		}
		File f = new File(path);
		if(f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			LineNumberReader br= null;
			try {
				br = new LineNumberReader(new BufferedReader(new FileReader(f)));
				String line;
				while((line  = br.readLine()) != null) {
					if(line.contains(srchStr))//<------------this extra line for printing only those lines which has search String
					System.out.println("No : "+br.getLineNumber()+" : "+line);
				}
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
		System.out.println("Enter the file path : ");
		String path = sc2.nextLine();
		System.out.println("Enter the search String : ");
		String searchString = sc1.nextLine();
		printAllFileContentsWithLineNumber(path, searchString);
	}

}
