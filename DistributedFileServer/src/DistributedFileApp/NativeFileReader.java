package DistributedFileApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class NativeFileReader {

	static final String serversListFile = System.getProperty("user.home") + "/files/NativeFileList.config";

	public static boolean isNativeFile(String fileName) {
		try {
			List<String> fileContent = new ArrayList<>(
					Files.readAllLines((new File(serversListFile)).toPath(), StandardCharsets.UTF_8));
			if (fileContent.contains(fileName)) {
				return true;
			}
		} catch (IOException e1) {
			System.out.println("didn't get native file contents right");
		}
		return false;
	}

	public static void addToListOfNativeFiles(String nameOfFileToAdd) {

		BufferedWriter writer;

		nameOfFileToAdd = nameOfFileToAdd.trim();

		try {
			writer = new BufferedWriter(new FileWriter(serversListFile, true));

			writer.write(nameOfFileToAdd);
			writer.newLine();
			writer.close();

		} catch (IOException e) {
			System.out.println("An error occurred while adding the new file name to list of native files.");
		}
	}

	public static void removeFromListOfNativeFiles(String nameOfFileToRemove) {
		try {
			// read all content into list
			ArrayList<String> fileContent = new ArrayList<>(
					Files.readAllLines((new File(serversListFile)).toPath(), StandardCharsets.UTF_8));

			// change required line
			for (String s : fileContent) {
				if (s.equalsIgnoreCase(nameOfFileToRemove)) {
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