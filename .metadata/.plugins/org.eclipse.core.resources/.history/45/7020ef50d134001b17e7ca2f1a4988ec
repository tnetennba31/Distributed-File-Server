package DistributedFileApp;

import org.omg.CosNaming.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

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
			System.out.println(distributedFileImpl.csOpenRead("bee1.txt"));
			
			// This is how we would shut down the server
			//distributedFileImpl.shutdown();

		} catch (Exception e)
		{
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}

}
