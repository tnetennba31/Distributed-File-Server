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
	void execute()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the file to open for write:");
		String input = scanner.nextLine();

		String realFileName = DistributedFileClient.getDistributedFileImpl().csOpenWrite(input);
	
		try {
			
		    BufferedWriter writer = new BufferedWriter(new FileWriter(realFileName, true));
		    
		    String textToAppend;
		    
		    while(true) {
		    	
		    	System.out.println("Enter the text to append to the end of " + input 
						+ ". Press enter to exit.");
		    	
		    	textToAppend = scanner.nextLine();
		    	textToAppend = textToAppend.trim();
		    	if (textToAppend.isEmpty()) {break;}
		    	
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