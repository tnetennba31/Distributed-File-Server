package menuStateMachine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

		String realFileName = DistributedFileClient.getDistributedFileImpl().csOpenRead(input);
		if (realFileName.equalsIgnoreCase("Could not lock this file")) {
			System.out.println("Sorry, you cannot lock the file at this time");
		} else if (realFileName.equalsIgnoreCase("File Not Found")) {
			System.out.println("Sorry, a file by this name does not exist");
		} else {
			java.util.List<String> fileContents = null;
			try {
				fileContents = Files
						.readAllLines(Paths.get(System.getProperty("user.home") + "/files/" + realFileName));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				while (true) {
					System.out.println("Enter the line number to read. Enter a non-number to exit:");
					int chosenLine = keyboard.nextInt();// should probably check for errors.
					if (chosenLine < fileContents.size() && chosenLine >= 0) {
						System.out.println(fileContents.get(chosenLine));
					} else {
						System.out.println("Line number invalid.");
					}
				}
			} catch (InputMismatchException e) {
				DistributedFileClient.getDistributedFileImpl().csCloseRead(realFileName);
				return;
			}
		}

	}

}