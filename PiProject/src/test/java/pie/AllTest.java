package pie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	@SuppressWarnings("unused")
	private int exitCode;

	@BeforeClass
	public static void setUp() {
		consoleText = new ByteArrayOutputStream();
		System.setOut(new PrintStream(consoleText));
		System.setErr(new PrintStream(consoleText));
	}

	@AfterClass
	public static void tearDown() {
		System.setOut(System.out);
		System.setErr(System.err);
	}

	@Before
	public void beforeEachTest() {
		consoleText.reset();
		app = new EstimatePi() {
			@Override
			public void exitApp(int code) {
				exitCode = code;
			}
		};
	}

	@Test
	public void testAppIsNotNull() {
		assertNotNull("app should not be null", app);
	}

	@Test
	public void testArgsNotNumber() {
		String[] args = { "bbb" };
		app.init(args);
		assertMessage(EstimatePi.MSG_MAX_N_NUMBER);
	}

	@Test
	public void testWrongNumerArgs() {
		String[] args = { "100000", "1000" };
		app.init(args);
		assertMessage(EstimatePi.MSG_WRONG_NUMBER_ARGS);
	}

	@Test
	public void testNoArgs() {
		String[] args = {};
		app.init(args);
		assertMessage(EstimatePi.MSG_WRONG_NUMBER_ARGS);
	}
	
	@Test
	public void testNegativeNumber() {
		String[] args = {"-10000"};
		app.init(args);
		assertMessage(EstimatePi.MSG_MAX_N_POSITIVE);
	}

	// helper method
	private void assertMessage(String expectedMessage) {
		assertEquals(expectedMessage + EOL + EstimatePi.USAGE + EOL, consoleText.toString());
	}
}
