package menuStateMachine;

import java.util.Scanner;

/**
 * This action gets some information from the user and does something with it
 * 
 * @author merlin
 *
 */
public class ReadAction extends MenuAction
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
		System.out.println("I can do something with this input: " + input);
	}

}
