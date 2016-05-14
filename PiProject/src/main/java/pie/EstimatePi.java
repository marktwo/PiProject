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

import java.util.InputMismatchException;
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
	// Note: system limit is: 2^32 - 1
	static int max_n = 0;

	// sum of the series
	static double sum = 0;

	// calculated estimate of pi
	static double pi = 0;

	// Scanner for user input
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		init(args);
		start();

		pi = 4 * sum;

		System.out.println("-> pi = " + pi);
	}

	/*
	 * initialise this instance; get max_n
	 */
	private static void init(String[] args) {
		// only one argument required; max_n
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
			} catch (NumberFormatException e) {
				System.out.println("max_n must be a number, please try again.");
				System.exit(0);
			}
		}
	}

	/*
	 * Interactive CLI mode; input n, output pi and duration
	 */
	private static void start() {
		// Get user input
		System.out.println("Enter number of terms to use in series (x to quit).");

		int nTerms = 0;

		while (true) {
			System.out.println();
			System.out.print("   n  = ");
			try {
				nTerms = scanner.nextInt();

				if (nTerms < 1 || nTerms > max_n) {
					System.out.println("n must be between 1 and " + max_n + ", please try again");
				} else {
					// TODO add stopwatch
					calculateSum(nTerms);

					pi = 4 * sum;
					System.out.println("-> pi = " + pi);
					sum = 0;
				}
			} catch (InputMismatchException e) {
				System.out.println("Done.");
				System.exit(0);
			}
		}
	}

	// calculate the sum of the series
	private static void calculateSum(int terms) {
		// TODO Auto-generated method stub
		for (int n = 0; n <= terms; n++) {
			sum += ((Math.pow(-1, n)) / ((2 * n) + 1));
		}
	}
}
