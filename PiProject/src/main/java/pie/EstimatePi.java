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

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

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

	static final String USAGE = "Usage: estimatepi max_n";
	static final String MSG_WRONG_NUMBER_ARGS = "1 arg is required";
	static final String MSG_MAX_N_POSITIVE = "max_n must be a positive number.";
	static final String MSG_MAX_N_NUMBER = "max_n must be a number.";

	// Scanner for user input
	static Scanner scanner = null;

	private static EstimatePi est = null;

	// Maximum number of terms to use in series
	// Note: system limit is: 2^32 - 1
	private int max_n = 0;

	// sum of the series
	private double sum = 0;

	// calculated estimate of pi
	private double pi = 0;

	private String errorMsg = "";

	public EstimatePi() {
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {

		est = new EstimatePi();
		est.init(args);
	}

	/*
	 * Validate the input args; get max_n
	 */
	private boolean validate(String[] userArgs) {
		boolean result = false;

		// only one argument required; max_n
		if (userArgs == null || userArgs.length == 0 || userArgs.length > 1) {
			errorMsg = MSG_WRONG_NUMBER_ARGS;
		} else {
			try {
				max_n = Integer.parseInt(userArgs[0]);

				if (max_n >= 1) {
					result = true;
				} else {
					errorMsg = MSG_MAX_N_POSITIVE;
				}
			} catch (NumberFormatException e) {
				errorMsg = MSG_MAX_N_NUMBER;
			}
		}

		return result;
	}

	/*
	 * initialise this instance
	 */
	public void init(String[] userArgs) {
		if (validate(userArgs)) {
			est.start();
		} else {
			System.out.println(errorMsg);
			System.out.println(USAGE);
			System.exit(1);
		}
	}

	/*
	 * Interactive CLI mode; input n, output pi and duration
	 */
	private void start() {
		// Get user input
		System.out.println("Enter number of terms to use in series (x to quit).");
		System.out.println("max_n = " + max_n);

		int nTerms = 0;

		while (true) {
			System.out.println();
			System.out.print("   n  = ");
			try {
				nTerms = scanner.nextInt();

				if (nTerms < 1 || nTerms > max_n) {
					System.out.println("n must be between 1 and " + max_n + ", please try again");
				} else {
					long tStart = System.currentTimeMillis();

					calculateSeriesTotal(nTerms);

					long tDelta = System.currentTimeMillis() - tStart;

					pi = 4 * sum;
					System.out.println("-> pi = " + pi);
					System.out.println("-> t  = " + tDelta + " milliseconds");
					sum = 0;
				}
			} catch (InputMismatchException e) {
				System.out.println("Done.");
				System.exit(0);
			}
		}
	}

	// calculate the sum of the series
	private void calculateSeriesTotal(int terms) {
		// use exp4j for evaluating mathematical expression
		// probably overkill for a simple expression
		Expression ex = new ExpressionBuilder("(-1)^n / (2n + 1)").variables("n").build();

		for (int n = 0; n <= terms; n++) {
			ex.setVariable("n", n);
			sum += ex.evaluate();
		}

	}
}
