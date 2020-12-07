package DistributedFileApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class LockedFilesManager {

	static final String lockedFilesList = System.getProperty("user.home") + "/files/LockedFiles.config";
//	private static BufferedReader bufferedReader;
//
//	static {
//		resetReader();
//	}

	public static boolean isLockedFile(String fileName) {
		try {
			List<String> fileContent = new ArrayList<>(
					Files.readAllLines((new File(lockedFilesList)).toPath(), StandardCharsets.UTF_8));
			if (fileContent.contains(fileName)) {
				return true;
			}
		} catch (IOException e1) {
			System.out.println("didn't get native file contents right");
		}
		return false;
//		resetReader();
//		try {
//			String s = bufferedReader.readLine();
//			while (s != null) {
//				if (s.contentEquals(fileName))
//					return true;
//				s = bufferedReader.readLine();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return false;
	}

//	public static void resetReader() {
//		try {
//			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(lockedFilesList)));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public static void addToLockedList(String fileToLock) {

		BufferedWriter writer;

		fileToLock = fileToLock.trim();

		try {
			writer = new BufferedWriter(new FileWriter(lockedFilesList, true));

			writer.newLine();
			writer.write(fileToLock);
			writer.close();

		} catch (IOException e) {
			System.out.println("An error occurred while adding the file to locked list.");
		}
	}

	public static void removeFromLockedList(String fileToUnlock) {
//		resetReader();
		try {
			// read all content into list
			ArrayList<String> fileContent = new ArrayList<>(
					Files.readAllLines((new File(lockedFilesList)).toPath(), StandardCharsets.UTF_8));

			// change required line
			for (String s : fileContent) {
				if (s == fileToUnlock) {
					fileContent.remove(fileContent.indexOf(s));
				}
			}

			// write back to file
			Files.write((new File(lockedFilesList)).toPath(), fileContent, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("uh oh spaghetti-o, removing from locked file list");
		}
	}

}