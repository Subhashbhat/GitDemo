//WAP to edit a given input with an another in the given path
package editAGivenInputWithAnotherInTheGivenPath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test7 {

	public static void replaceInputWithAnotherIntheGivenPath(String path, String replaceStr, String withStr) {

		if (path == null) {
			throw new IllegalArgumentException("Path is not valid");
		}
		File f = new File(path);
		if (f.exists() && f.isFile() && f.getName().endsWith(".txt")) {
			BufferedReader br = null;
			BufferedWriter bw = null;
			try {
				br = new BufferedReader(new FileReader(f));
				String line;
				List<String> contents = new ArrayList<String>();
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					if (line.contains(replaceStr)) {
						line = line.replace(replaceStr, withStr);// <----------------
					}
					contents.add(line);
				}
				br.close();
				br = null;
				bw = new BufferedWriter(new FileWriter(f));
				for (String str : contents) {
					bw.write(str);
					bw.newLine();
				}
				bw.flush();

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
				if (bw != null) {
					try {
						bw.close();
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
		System.out.println("Enter the search string : ");
		String srchStr = sc1.next();
		System.out.println("Enter the replace String : ");
		String replace = sc1.next();
		replaceInputWithAnotherIntheGivenPath(path, srchStr, replace);
	}

}
/*Input : 
test this is
is this a test
test it is this
blah blah blah
isisis
sumsumne

OutPut : 
test thizz izz
izz thizz a test
test it izz thizz
izzizzizz
*/