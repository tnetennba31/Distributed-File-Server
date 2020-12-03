package DistributedFileApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;


public class FileManager {

	//hashmap keeps track of how many clients are reading each file
	static HashMap<String, Integer> clientsReading = new HashMap<String, Integer>();
	
	static synchronized String getRealFileName(String inputFileName) {
		
		String realFileName = addVersionNumberToFileName(inputFileName);
		String path = System.getProperty("user.home") + "/files/" + realFileName;
		
		boolean fileExists = (new File(path)).exists();
	
		if (!fileExists) {
//			DistributedFileServer.connectToAnotherServer();
			//get from other server and create in fileSystem and put in hashmap
			//return name
			
			clientsReading.put(realFileName, 1);
			return realFileName;
		} else {
			
			//if file exists already, add new reader to hashmap and return name
			clientsReading.put(realFileName, clientsReading.get(realFileName) + 1);
			return realFileName;			
		}
	}
	
	private static String addVersionNumberToFileName(String inputFileName) {
		return inputFileName;//change this when we do version numbers
	}

	static void doneReading(String inputFileName) {
		//decrement number of clients reading in hashmap
		String realFileName = addVersionNumberToFileName(inputFileName);
		clientsReading.put(realFileName, clientsReading.get(realFileName) - 1);
		
		//if no more readers, delete file and remove hashmap entry
		if (clientsReading.get(realFileName) == 0) {
			clientsReading.remove(realFileName);
			
			//delete the local file
			File fileToDelete = new File(realFileName);
			fileToDelete.delete();
		}		
	}

	public static HashMap<String, Integer> getClientsReading() {
		return clientsReading;
	}
	
	
	


}
