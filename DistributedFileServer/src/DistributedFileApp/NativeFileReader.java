package DistributedFileApp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class NativeFileReader {
	static String serversListFile = System.getProperty("user.home") + "/files/NativeFileList.config";
	private static BufferedReader bufferedReader;
	
	static {
		resetReader();
	}
	
	public static boolean isNativeFile(String fileName) {
		resetReader();
		try {
			String s = bufferedReader.readLine();
			while (s != null) {
				if (s.contentEquals(fileName)) return true;
				s = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void resetReader() {
		try {
			bufferedReader = new BufferedReader(
								new InputStreamReader(
								new FileInputStream(serversListFile)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}