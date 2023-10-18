package copyFromOneFileToAnotherFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test10 {

	public static void fileCopy(String fromPath, String toPath) {
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		try {
			bin = new BufferedInputStream(new FileInputStream(fromPath));
			bout = new BufferedOutputStream(new FileOutputStream(toPath));

			int data;
			while ((data = bin.read()) != -1) {
				bout.write(data);
			}
			bout.flush();
		} catch (IOException e) {

		} finally {
			if (bin != null) {
				try {
					bin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bout != null) {
				try {
					bout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter the path : ");
		String path = sc2.next();
		System.out.println("Enter the destinationPath : ");
		String toPath = sc2.next();

		File f = new File(path);
		if (f.exists() && f.isDirectory()) {
			File[] fa = f.listFiles();
			for (File fi : fa) {
				if (fi.getName().endsWith(".txt")) {
					System.out.println(fi.getAbsolutePath());
					String outFilePath = toPath + "/" + fi.getName();
					System.out.println("outFilePath = " + outFilePath);
					fileCopy(fi.getAbsolutePath(), outFilePath);
				}
			}
		} else {
			System.out.println("Given path is not a directory");
		}
	}

}
