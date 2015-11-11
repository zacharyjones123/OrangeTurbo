package edu.ncsu.csc216.androtech.model.repair_center;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The tester class for ExpertDroid
 * 
 * @author Zachary R. Jones
 *
 */
public class ExpertDroidTest {
	/** Expert Droid 1 */
	private TechDroid expertDroid1;

	/**
	 * The setup class for ExpertDroidTest
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		expertDroid1 = new ExpertDroid();
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.androtech.model.repair_center.ExpertDroid#ExpertDroid()}
	 * .
	 */
	@Test
	public void testExpertDroid() { // DONE
		TechDroid.startDroidNumberingAt01();
		expertDroid1 = new ExpertDroid();
		assertEquals(expertDroid1.getDroidID(), "01E");
		assertEquals(expertDroid1.isAssigned(), false);
	}

}