package DistributedFileApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {

	public static boolean fileExistsLocally(String fileName) {
		String path = System.getProperty("user.home") + "/files/" + fileName;
		return (new File(path)).exists();
	}

	public static boolean fileExistsRemotely(String fileName, DistributedFileImpl server) {
		String fileContents = server.searchOtherServers(fileName);
		if (fileContents.equalsIgnoreCase("File Not Found")) {
			return false;
		} else {
			copyToLocal(fileName, fileContents);
			return true;
		}
	}

	private static void copyToLocal(String fileName, String fileContents) {
		try {
			File file = new File(System.getProperty("user.home") + "/files/" + fileName);
			FileWriter fw = new FileWriter(file);
			fw.write(fileContents);
			fw.close();
		} catch (IOException e) {
			System.out.println("Unable to create file");
			e.printStackTrace();
		}
	}

	public static void addClientReading(String fileName, boolean isNewFile, HashMap<String, Integer> clientsReading) {
		if (isNewFile) {
			clientsReading.put(fileName, 1); // add to hashmap
		} else {
			clientsReading.put(fileName, clientsReading.get(fileName) + 1);
		}
		System.out.println("Reader added. Number reading " + fileName + " is now " + clientsReading.get(fileName));
	}

	static void doneReading(String inputFileName, HashMap<String, Integer> clientsReading) {
		// decrement number of clients reading in hashmap
		clientsReading.put(inputFileName, clientsReading.get(inputFileName) - 1);
		System.out.println(
				"Reader removed. Number reading " + inputFileName + " is now " + clientsReading.get(inputFileName));

	}

	static void deleteFile(String inputFileName, HashMap<String, Integer> clientsReading) {
		clientsReading.remove(inputFileName);
		System.out.println("No one is reading out of date copy of " + inputFileName + " so it is being deleted.");

		try {
			// delete the local file
			File fileToDelete = new File(System.getProperty("user.home") + "/files/" + inputFileName);
			fileToDelete.delete();
		} catch (Exception e) {
			System.out.println("Couldn't delete this file.");
		}
	}

	/**
	 * Find a file if it exists far away
	 * 
	 * @param fileName
	 * @param server
	 * @return file contents or error message if nack
	 */
	public static String findForWriting(String fileName, DistributedFileImpl server) {
		for (DistributedFile s : server.getAllServerImpls()) {
			String openWriteOutput = s.ssOpenWrite(fileName);
			if (!openWriteOutput.equalsIgnoreCase("File Not Found")
					&& !openWriteOutput.equalsIgnoreCase("Could not lock this file")) {
				copyToLocal(fileName, openWriteOutput);
				return fileName;
			}
		}
		return "File Not Found";
	}

}
