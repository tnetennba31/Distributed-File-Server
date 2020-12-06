package DistributedFileApp;

import java.io.File;

public class FileVersionChanger {
	
	//Assumes real file name is of the form: #_name.txt
	public static final String delimitter = "_";
	
	public static int getVersionNumber(String fileName) {
		String[] results = fileName.split(delimitter, 2);
		return Integer.parseInt(results[0]);
	}
	
	public static int getVersionNumber(File file) {
		String[] results = file.getName().split(delimitter, 2);
		return Integer.parseInt(results[0]);
	}
	
	public static String getNameWithoutVersionNumber(String fileName) {
		String[] results = fileName.split(delimitter, 2);
		return results[1];
	}
	
	public static String getNameWithoutVersionNumber(File file) {
		String[] results = file.getName().split(delimitter, 2);
		return results[1];
	}
	
	
//	public static String incrementVersionNumber(String fileName) {
//		String[] results = fileName.split(delimitter, 2);
//		
//		int version = Integer.parseInt(results[0]);
//		version++;
//		
//		results[0] = Integer.toString(version);
//		
//		return results[0] + "_" + results[1];
//	}
	
	public static void incrementVersionNumber(File file) {
		String[] results = file.getName().split(delimitter, 2);
		
		int version = Integer.parseInt(results[0]);
		version++;
		results[0] = Integer.toString(version);
		
		String newName = results[0] + "_" + results[1];
		
		//not sure which get path method should be used here
		File fileWithOldName = new File(file.getPath() + file.getName());
		File fileWithNewName = new File(file.getPath() + newName); 
		
		if (!fileWithOldName.exists()) {
			System.out.println("Error: You can't rename a file that does not exist.");
			return;
		}
		
		if (fileWithNewName.exists()) {
			System.out.println("Error: A file with the new version number already exists.");
			return;
		}
		
		boolean success = fileWithOldName.renameTo(fileWithNewName);
		
		if(!success) {
			System.out.println("Unable to change version number.");
		}	
	}
}
