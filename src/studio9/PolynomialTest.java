package studio9;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PolynomialTest {
	private Polynomial p0 = new Polynomial();
	private Polynomial p1 = synthPoly(new double[] {  4, -7,  0, 11});
	private Polynomial p2 = synthPoly(new double[] {  7,  5, -2,  5});
	private Polynomial p3 = synthPoly(new double[] { -1,  2,  3, -4, 5});
	private Random random = new Random();

	/**
	 * Helper method to generate a Polynomial from an array of doubles.
	 * @param coeffs
	 * @return
	 */
	private Polynomial synthPoly(double[] coeffs) {
		Polynomial ans = new Polynomial();
		for (double d : coeffs) {
			ans.addTerm(d);
		}
		return ans;
	}

	
	@Test
	public void testDeriv() {
		Polynomial p1Deriv = synthPoly(new double[] { 12,  -14, 0});
		Polynomial p2Deriv = synthPoly(new double[] {  21, 10, -2 });

		assertEquals(p1Deriv, p1.derivative());
		assertEquals(p2Deriv, p2.derivative());
		assertEquals(p0, p0.derivative());
	}

	@Test
	public void testEval() {
		assertEquals(77.0, p2.evaluate(2.0), .01);
		assertEquals(0.0,  p0.evaluate(100), .01);
	}

	/**
	 * Tests the derivative method of the polynomial class using randomly generated inputs
	 */
	@Test
	public void testDerivRandom() {
		
		for(int i = 0; i < 100; i ++)
		{
			//get a polynomial with random length between 1 and 8
			double [] coeffs = genRandomCoeffs(random.nextInt(7)+1);
			Polynomial p1 = synthPoly(coeffs);
			Polynomial der = new Polynomial();
			
			for (int j=0; j < coeffs.length-1; ++j) {
				der.addTerm(coeffs[j]*(coeffs.length - j - 1));
			}
			if(der.toString().compareTo(p1.derivative().toString()) != 0)
			{
				printError("Error computing derivative of: " + p1.toString() + ": Use the power rule on each term of the polynomial ((exp * coefficient)x^(exp - 1)). Make sure that your order of operations is correct.", der, p1.derivative());
			}
			assertEquals(der, p1.derivative());
		}
	}

	/**
	 * Use randomly generated input to test the eval method of the Polynomial class
	 */
	@Test
	public void testEvalRandom() {
		
		for(int i = 0; i < 100; i++) {
			double [] coeffs = genRandomCoeffs(random.nextInt(7)+1);
			Polynomial p1 = synthPoly(coeffs);
			double result = 0;
			double x = random.nextDouble() * 100;
			
			for(int j = 0; j < coeffs.length; j++)
			{
				result = result + coeffs[j] * Math.pow(x, (double)coeffs.length - j - 1);
			}
			
			if(p1.evaluate(x) > result + 1 || p1.evaluate(x) < result - 1)
			{
				System.out.println("Error evaluating: " + p1.toString());
			}
			assertEquals(result, p1.evaluate(x), 1);
		}
	}

	/**
	 * Geneates an array of random coefficients
	 * @param num The size of the array
	 * @return an array of random numbers, each in the range 0...99
	 */
	private double[] genRandomCoeffs(int num) {
		double[] ans = new double[num];
		for (int i=0; i < num; ++i) {
			ans[i] = random.nextInt(100);
		}
		return ans;
	}

	
	@Test
	public void testPrint() {
		System.out.println("p2 is " +p2);
		System.out.println("p2's derivative is " + p2.derivative());
		System.out.println("new poly is " + new Polynomial());
	}
	
	private void printError(String msg, Polynomial expected, Polynomial actual)
	{
		System.out.println(msg);
		System.out.println("Expected: " + expected.toString());
		System.out.println("Actual: " + actual.toString());
	}
}
