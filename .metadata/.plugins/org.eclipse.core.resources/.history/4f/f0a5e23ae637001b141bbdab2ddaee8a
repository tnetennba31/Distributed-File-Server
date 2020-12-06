package menuStateMachine;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import DistributedFileApp.DistributedFileClient;

public class WriteLineAction extends MenuAction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the file to open for write:");
		String input = scanner.nextLine();

		String realFileName = DistributedFileClient.getDistributedFileImpl().csOpenWrite(input);
	    Path realFilePath = new File(realFileName).toPath();
	    
		try {
					    
		    String replacementText;
		    
		    while(true) {
		    	
				System.out.println("Enter the line number that you want to change. Enter a non-number to exit:");
				int chosenLine = scanner.nextInt();
				scanner.nextLine(); //account for left over input
				
		    	System.out.println("Enter the text that you want to replace line " 
		    			+ chosenLine + " of " + input + " with.");
		    	
				chosenLine = chosenLine - 1; //account for computer starting from 0

		    	replacementText = scanner.nextLine();
		    	replacementText = replacementText.trim(); //remove white space (newlines characters)
		    	
		    	replaceLineInFile(realFilePath, chosenLine, replacementText);
		    	    	
		    }
		    		    
		} catch (InputMismatchException e) {
			//do nothing			
		} catch (IOException e) {
			System.out.println("Error writing to file");
		} 
		
		DistributedFileClient.getDistributedFileImpl().csCloseWrite(input);		
	}
	
	private void replaceLineInFile(Path realFilePath, int chosenLine, String replacementText) throws IOException {
    	//read all content into array
		List<String> fileContent = new ArrayList<>(Files.readAllLines(realFilePath, StandardCharsets.UTF_8));

		//change required line
    	fileContent.set(chosenLine, replacementText);

    	//write back to array
    	Files.write(realFilePath, fileContent, StandardCharsets.UTF_8);
    	
    	//Replace at character index instead of line index. not used
//		RandomAccessFile file = new RandomAccessFile(new File(realFileName), "rw");
//		file.seek(chosenLine);
//		file.write(replacementText.getBytes());				
//		file.close();		
	}
}