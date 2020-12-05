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

		String fileName = DistributedFileClient.getDistributedFileImpl().csOpenRead(input);
		if (fileName.equalsIgnoreCase("File Not Found")) {
			System.out.println(fileName);
		} else {
			java.util.List<String> fileContents = null;
			try {
				fileContents = Files.readAllLines(Paths.get(System.getProperty("user.home") + "/files/" + fileName));
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
				DistributedFileClient.getDistributedFileImpl().csCloseRead(fileName);
				return;
			}
		}

	}

}