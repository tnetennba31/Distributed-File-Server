package DistributedFileApp;


/**
* DistributedFileApp/DistributedFilePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DistributedFile.idl
* Wednesday, December 2, 2020 12:23:49 AM EST
*/

public abstract class DistributedFilePOA extends org.omg.PortableServer.Servant
 implements DistributedFileApp.DistributedFileOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("csOpenRead", new java.lang.Integer (0));
    _methods.put ("csCloseRead", new java.lang.Integer (1));
    _methods.put ("csOpenWrite", new java.lang.Integer (2));
    _methods.put ("csCloseWrite", new java.lang.Integer (3));
    _methods.put ("ssOpenRead", new java.lang.Integer (4));
    _methods.put ("ssCloseRead", new java.lang.Integer (5));
    _methods.put ("ssOpenWrite", new java.lang.Integer (6));
    _methods.put ("ssLockWrite", new java.lang.Integer (7));
    _methods.put ("ssCloseWrite", new java.lang.Integer (8));
    _methods.put ("shutdown", new java.lang.Integer (9));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // DistributedFileApp/DistributedFile/csOpenRead
       {
         String fileName = in.read_string ();
         String $result = null;
         $result = this.csOpenRead (fileName);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // DistributedFileApp/DistributedFile/csCloseRead
       {
         String fileName = in.read_string ();
         boolean $result = false;
         $result = this.csCloseRead (fileName);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // DistributedFileApp/DistributedFile/csOpenWrite
       {
         String fileName = in.read_string ();
         String $result = null;
         $result = this.csOpenWrite (fileName);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // DistributedFileApp/DistributedFile/csCloseWrite
       {
         String fileName = in.read_string ();
         boolean $result = false;
         $result = this.csCloseWrite (fileName);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // DistributedFileApp/DistributedFile/ssOpenRead
       {
         String fileName = in.read_string ();
         String $result = null;
         $result = this.ssOpenRead (fileName);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 5:  // DistributedFileApp/DistributedFile/ssCloseRead
       {
         String fileName = in.read_string ();
         boolean $result = false;
         $result = this.ssCloseRead (fileName);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 6:  // DistributedFileApp/DistributedFile/ssOpenWrite
       {
         String fileName = in.read_string ();
         String $result = null;
         $result = this.ssOpenWrite (fileName);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 7:  // DistributedFileApp/DistributedFile/ssLockWrite
       {
         String fileName = in.read_string ();
         boolean $result = false;
         $result = this.ssLockWrite (fileName);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 8:  // DistributedFileApp/DistributedFile/ssCloseWrite
       {
         String fileName = in.read_string ();
         String $result = null;
         $result = this.ssCloseWrite (fileName);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 9:  // DistributedFileApp/DistributedFile/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:DistributedFileApp/DistributedFile:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public DistributedFile _this() 
  {
    return DistributedFileHelper.narrow(
    super._this_object());
  }

  public DistributedFile _this(org.omg.CORBA.ORB orb) 
  {
    return DistributedFileHelper.narrow(
    super._this_object(orb));
  }


} // class DistributedFilePOA
