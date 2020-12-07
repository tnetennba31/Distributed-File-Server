package DistributedFileApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class NativeFileReader {

	static final String serversListFile = System.getProperty("user.home") + "/files/NativeFileList.config";
	private static BufferedReader bufferedReader;

	static {
		resetReader();
	}

	public static boolean isNativeFile(String fileName) {
		resetReader();
		try {
			String s = bufferedReader.readLine();
			while (s != null) {
				if (s.contentEquals(fileName))
					return true;
				s = bufferedReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void resetReader() {
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(serversListFile)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void addToListOfNativeFiles(String nameOfFileToAdd) {

		BufferedWriter writer;

		nameOfFileToAdd = nameOfFileToAdd.trim();

		try {
			writer = new BufferedWriter(new FileWriter(serversListFile, true));
			
			writer.newLine();
			writer.write(nameOfFileToAdd);
			writer.close();

		} catch (IOException e) {
			System.out.println("An error occurred while adding the new file name to list of native files.");
		}
	}

	public static void removeFromListOfNativeFiles(String nameOfFileToRemove) {
		resetReader();
		try {
			// read all content into list
			ArrayList<String> fileContent = new ArrayList<>(
					Files.readAllLines((new File(serversListFile)).toPath(), StandardCharsets.UTF_8));

			// change required line
			for (String s : fileContent) {
				if (s == nameOfFileToRemove) {
					fileContent.remove(fileContent.indexOf(s));
				}
			}

			// write back to file
			Files.write((new File(serversListFile)).toPath(), fileContent, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("uh oh spaghetti-o, removing from native file list");
		}
	}

}