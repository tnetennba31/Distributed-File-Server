package DistributedFileApp;


/**
* DistributedFileApp/byteSeqHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DistributedFile.idl
* Wednesday, December 2, 2020 12:23:49 AM EST
*/

public final class byteSeqHolder implements org.omg.CORBA.portable.Streamable
{
  public byte value[] = null;

  public byteSeqHolder ()
  {
  }

  public byteSeqHolder (byte[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DistributedFileApp.byteSeqHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DistributedFileApp.byteSeqHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DistributedFileApp.byteSeqHelper.type ();
  }

}
