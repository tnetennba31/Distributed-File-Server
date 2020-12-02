package DistributedFileApp;

import org.omg.CosNaming.*;

import menuStateMachine.EndState;
import menuStateMachine.StartState;
import menuStateMachine.State;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.omg.CORBA.*;

/**
 * A simple client that just gets a
 * @author madeline, joshua, ace, adam
 *
 */
public class DistributedFileClient
{
	static DistributedFile distributedFileImpl;

	/**
	 * Just do each operation once
	 * @param args ignored
	 */
	public static void main(String args[])
	{
		try
		{
			String address[] = {"-ORBInitialHost", "localhost", "-ORBInitialPort", "1058", "-port", "1059"};
			// create and initialize the ORB
			ORB orb = ORB.init(address, null);

			// get the root naming context
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			// Use NamingContextExt instead of NamingContext. This is
			// part of the Interoperable naming Service.
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// resolve the Object Reference in Naming
			String name = "DistributedFile";
			distributedFileImpl = DistributedFileHelper.narrow(ncRef.resolve_str(name));

			System.out.println("Obtained a handle on server object: " + distributedFileImpl);
			
			Scanner keyboard = new Scanner(System.in);
			State currentState = new StartState();
			while (currentState.getClass() != EndState.class)
			{
				currentState.printOptions();
				try
				{
					int option = keyboard.nextInt();
					currentState = currentState.processOption(option);
				} catch (InputMismatchException e)
				{
					System.out.println("Please enter the number of the option you'd like to select");
					
				}
				keyboard.nextLine();
			}
			keyboard.close();
			
			// This is how we would shut down the server
			//distributedFileImpl.shutdown();

		} catch (Exception e)
		{
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}

	public static DistributedFile getDistributedFileImpl() {
		return distributedFileImpl;
	}

}
