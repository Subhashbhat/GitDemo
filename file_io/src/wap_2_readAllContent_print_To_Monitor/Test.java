/*WAP to read all the content of a text file, given a path and then print to the monitor*/
package wap_2_readAllContent_print_To_Monitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void printTextFileContents(String path) {
		if (path == null) {
			throw new IllegalArgumentException("Path is not valid");
		}
		File f = new File(path);
		if (f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
				String line;
				while((line = br.readLine()) != null) {
					System.out.println(line);
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
		
		//Test.printTextFileContents("C:\\subhash\\file_io\\src\\file_io_practise\\Test.txt");
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter path of a file : ");
		String path = sc1.nextLine();
		printTextFileContents(path);
	}

}
