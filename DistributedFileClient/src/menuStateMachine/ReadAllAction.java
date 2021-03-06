package menuStateMachine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import DistributedFileApp.DistributedFileClient;

/**
 * This action gets some information from the user and does something with it
 * 
 * @author merlin
 *
 */
public class ReadAllAction extends MenuAction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	void execute() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the file to open for read:");
		String input = keyboard.nextLine();

		String realFileName = DistributedFileClient.getDistributedFileImpl().csOpenRead(input);
		if (realFileName.equalsIgnoreCase("Could not lock this file")) {
			System.out.println("Sorry, you cannot lock the file at this time");
		} else if (realFileName.equalsIgnoreCase("File Not Found")) {
			System.out.println("Sorry, a file by this name does not exist");
		} else {

			try {
				List<String> allLines = Files
						.readAllLines(Paths.get(System.getProperty("user.home") + "/files/" + realFileName));
				for (String s : allLines) {
					System.out.println(s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			DistributedFileClient.getDistributedFileImpl().csCloseRead(input);
		}
	}

//	@Override
//	void execute()
//	{
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("Enter the name of the file to open for read:");
//		String input = keyboard.nextLine();
////		System.out.println(DistributedFileClient.getDistributedFileImpl().csOpenRead(input));
//		
//		try {
//		String path = DistributedFileClient.getDistributedFileImpl().csOpenRead(input);
//		Scanner s = new Scanner(new File(path));
//		StringBuffer contents = new StringBuffer("");
//		while (s.hasNext()) {
//			contents.append(s.nextLine() + "\n");
//		}
//
//		s.close();
//		FileManager.doneReading(path);
//
////		return contents.toString();
//		System.out.println(contents.toString());
//	} catch (FileNotFoundException e) {
//	}
//		
//	}

}