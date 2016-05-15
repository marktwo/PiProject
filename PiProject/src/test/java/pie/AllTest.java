package pie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AllTest {

	static final String EOL = System.getProperty("line.separator");
	static ByteArrayOutputStream consoleText;
	static PrintStream console;

	private EstimatePi app = null;

	@BeforeClass
	public static void setUp() {
		consoleText = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(consoleText));
	}

	@AfterClass
	public static void tearDown() {
		System.setOut(console);
	}

	@Before
	public void beforeEachTest() {
		app = new EstimatePi();
	}

	@Test
	public void testAppIsNotNull() {
		assertNotNull("app should not be null", app);
	}

	// @Test
	public void test1Arg() {
		String[] args = { "100000" };

		app.init(args);
		// assertEquals(EstimatePi.. );
	}

	// @Test
	public void testNoArgs() {
		String[] args = {};
		app.init(args);
		assertEquals(EstimatePi.MSG_WRONG_NUMBER_ARGS + EOL + EstimatePi.USAGE + EOL, consoleText.toString());
	}

	@Test
	public void testArgsNotNumber() {
		String[] args = { "bbb" };
		app.init(args);
		assertEquals(EstimatePi.MSG_MAX_N_NUMBER + EOL + EstimatePi.USAGE + EOL, consoleText.toString());
	}

	// @Test
	public void testNZero() {
		// double result = estimate.sum;
		System.out.println("testNZero");

	}

	// @Test
	public void NZeroTest() {
		System.out.println("NZeroTest");
		assertEquals(1, 0);
	}

	// @Test
	public void test() {
		fail("Not yet implemented");
	}

}
