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

	private static EstimatePi estimate;

	@BeforeClass
	public static void beforeEachTest() {
		System.out.println("beforeEachTest");
		estimate = new EstimatePi();
		System.out.println(EstimatePi.max_n);
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
