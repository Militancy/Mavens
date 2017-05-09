package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
	@Test
	public void testInErstemHalbenJahr1() {
		assertTrue("This should evaluate to true", Util.istErstesHalbjahr(1));
	}

	@Test
	public void testInErstemHalbenJahr6() {
		assertTrue("This should evaluate to true", Util.istErstesHalbjahr(6));
	}

	@Test
	public void testInErstemHalbenJahr7() {
		assertFalse("This should evaluate to false", Util.istErstesHalbjahr(7));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInErstemHalbenJahr0() {
		Util.istErstesHalbjahr(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInErstemHalbenJahr13() {
		Util.istErstesHalbjahr(13);
	}
}
