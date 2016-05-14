/*
 * Copyright (c) 2016 Mark Murray
 * mamurray@optusnet.com.au
 * 
 * All rights reserved.
 * 
 * For coding assignment purposes only.
 * 
 */

package pie;

/**
 * Produces an approximation to the numerical value of pi.
 * 
 * Uses the following series: pi = 4 * Sum[(-1)^n/2n+1]
 * 
 * The number of terms (n) can specified.
 * 
 * @author Mark Murray
 * @version 1.0
 */
class EstimatePi {

	public static void main(String[] args) {

		// Default number of terms
		int numberTerms = 9000;

		double pi = 0;

		if (args.length == 0) {
			System.out.println(
					"Usage: estimatepi n\nWhere n is the numer of terms to use in the series.\nUsing default number of terms: 9,000");
		} else {
			int argN = 0;

			try {
				argN = Integer.parseInt(args[0]);

				if (argN > 0) {
					numberTerms = argN;
				} else {
					System.out.println("n must be a positive number, please try again.");
					System.exit(0);
				}
			} catch (NumberFormatException e) {
				System.out.println("n must be a number, please try again.");
				System.exit(0);
			}

		}

		pi = 4 * piSum(numberTerms);

		System.out.println("pi = " + pi);
	}

	/*
	 * Calculates the Sum part of the series
	 * sum[(-1)^n/2n-1]
	 */
	private static double piSum(int n) {

		if (n < 0) {
			return 0;
		} else {
			return ((Math.pow(-1, n)) / ((2 * n) + 1)) + piSum(n - 1);
		}

	}
}
