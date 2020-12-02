package DistributedFileApp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestConfigReader {
	@Test
	public void testGetNextAddress() {
		assertEquals("address1", ConfigReader.getNextAddress());
		assertEquals("address2", ConfigReader.getNextAddress());
		ConfigReader.resetReader();
		assertEquals("address1", ConfigReader.getNextAddress());


	}

}
