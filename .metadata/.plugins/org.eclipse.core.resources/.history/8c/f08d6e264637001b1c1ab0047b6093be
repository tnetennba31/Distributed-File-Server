package menuStateMachine;
import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import DistributedFileApp.DistributedFileClient;

/**
 * This action gets some information from the user and does something with it
 * 
 * @author merlin
 *
 */
public class ReadAllAction extends MenuAction
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	void execute()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the file to open for read:");
		String input = keyboard.nextLine();
		System.out.println(DistributedFileClient.getDistributedFileImpl().csOpenRead(input));
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