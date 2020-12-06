package menuStateMachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import DistributedFileApp.DistributedFileClient;

public class WriteAppendAction extends MenuAction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the file to open for write:");
		String input = scanner.nextLine();

		String realFileName = DistributedFileClient.getDistributedFileImpl().csOpenWrite(input);
		if (realFileName.equalsIgnoreCase("Could not lock this file")) {
			System.out.println("Sorry, you cannot lock the file at this time");
		} else if (realFileName.equalsIgnoreCase("File Not Found")) {
			System.out.println("Sorry, a file by this name does not exist");
		} else {
			realFileName = System.getProperty("user.home") + "/files/" + realFileName;
			try {

				BufferedWriter writer = new BufferedWriter(new FileWriter(realFileName, true));
				String textToAppend;

				while (true) {

					System.out.println("Enter the text to append to the end of " + input + ". Press enter to exit.");

					textToAppend = scanner.nextLine();
					textToAppend = textToAppend.trim();
					if (textToAppend.isEmpty()) {
						break;
					}

					writer.newLine();
					writer.write(textToAppend);

				}
				writer.close();

			} catch (IOException e) {
				System.out.println("Error writing to file");
			}

			DistributedFileClient.getDistributedFileImpl().csCloseWrite(input);
		}
	}
}