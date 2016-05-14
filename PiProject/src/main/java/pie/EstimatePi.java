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

import java.util.Scanner;

/**
 * Produces an approximation to the numerical value of pi.
 * 
 * Uses the following series: pi = 4 * Sum[(-1)^n/2n+1]
 * 
 * The maximum number of terms to use in the series can be specified.
 * 
 * The number of terms (n) can specified.
 * 
 * @author Mark Murray
 * @version 1.0
 */
class EstimatePi {

	// Maximum number of terms to use in series
	static int max_n = 0;

	// sum of the series
	static double sum = 0;

	// calculated estimate of pi
	static double pi = 0;

	public static void main(String[] args) {

		init(args);
		start();

		// Default number of terms
		int numberTerms = 9000;

		double pi = 0;

		// only one argument required, max_n
		if (args.length == 0 || args.length > 1) {
			System.out.println("Usage: estimatepi max_n\nWhere max_n is the maximum number of terms in the series.");
			System.out.println("Example: estimatepi 100000");
			System.exit(0);
		} else {
			try {
				max_n = Integer.parseInt(args[0]);

				if (max_n < 1) {
					System.out.println("max_n must be a positive number, please try again.");
					System.exit(0);
				}

				// interactive mode; input n, output pi and duration
				Scanner scanner = new Scanner(System.in);
				int nTerms = 0;

				while (nTerms >= 0) {
					System.out.println("Enter the number of terms to use.");
					System.out.print("n = ");
					nTerms = scanner.nextInt();

				}

				// TODO use Scanner
				System.out.println("Enter number of terms to use in series (-1 to quit).");

				// user input need Scanner
				System.out.println("n = ");

			} catch (NumberFormatException e) {
				System.out.println("max_n must be a number, please try again.");
				System.exit(0);
			}

		}

		pi = 4 * piSum(numberTerms);

		System.out.println("pi = " + pi);
	}

	// initialise this instance; get max_n
	private static void init(String[] args) {
		// only one argument required, max_n
		if (args.length == 0 || args.length > 1) {
			System.out.println("Usage: estimatepi max_n\nWhere max_n is the maximum number of terms in the series.");
			System.out.println("Example: estimatepi 100000");
		} else {
			try {
				max_n = Integer.parseInt(args[0]);

				if (max_n < 1) {
					System.out.println("max_n must be a positive number, please try again.");
				}
			} catch (NumberFormatException e) {
				System.out.println("max_n must be a number, please try again.");
			}
		}
		System.exit(0);
	}

	private static void start() {
		// TODO Auto-generated method stub

	}

	private static void calculatePi() {
		// TODO Auto-generated method stub

	}

	/*
	 * Calculates the Sum part of the series sum[(-1)^n/2n-1]
	 */
	private static double piSum(int n) {

		if (n < 0) {
			return 0;
		} else {
			return ((Math.pow(-1, n)) / ((2 * n) + 1)) + piSum(n - 1);
		}

	}
}
