package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class TestFileLocking {

	@Test
	public void testFileLocking() throws IOException {
		File f = new File("beetest.txt");
		FileChannel fchannel = FileChannel.open(f.toPath(), StandardOpenOption.APPEND);
		FileLock flock = fchannel.tryLock();
		assertTrue(flock.isValid());
		assertFalse(flock.isShared());
		assertEquals(fchannel, flock.acquiredBy());
		
		File f2 = new File("beetest.txt");
		FileChannel fchannel2 = FileChannel.open(f2.toPath(), StandardOpenOption.APPEND);
		try {
			fchannel2.tryLock();
		} catch (OverlappingFileLockException e) {
			System.out.println("File is locked by someone else.");
		}
	}

}