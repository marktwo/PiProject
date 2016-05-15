package pie;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {

	private EstimatePi app;

	@BeforeClass
	public void beforeEachTest() {
		System.out.println("beforeEachTest");
		app = new EstimatePi();
	}
	
	@Test
	public void testNoArgs() {
		app.init(null);
		assertEquals("test", "fail");
	}

	@Test
	public void testNZero() {
//		double result = estimate.sum;
		System.out.println("testNZero");
		
	}
	
	@Test
	public void NZeroTest() {
		System.out.println("NZeroTest");
		assertEquals(1, 0);
	}

}
