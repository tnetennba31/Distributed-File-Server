package menuStateMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

import DistributedFileApp.DistributedFileClient;

public class ReadRecordAction extends MenuAction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	void execute() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the file to open for read:");
		String input = keyboard.nextLine();

		String fileString = DistributedFileClient.getDistributedFileImpl().csOpenRead(input);
		if (fileString.equalsIgnoreCase("File Not Found")) {
			System.out.println(fileString);
		} else {
			String fileAsArray[] = fileString.split("\\r?\\n");
			try {
				while (true) {
					System.out.println("Enter the line number to read. Enter a non-number to exit:");
					int chosenLine = keyboard.nextInt();// should probably check for errors.
					System.out.println(fileAsArray[chosenLine]);
				}
			} catch (InputMismatchException e) {
				return;
			}
		}

	}

}