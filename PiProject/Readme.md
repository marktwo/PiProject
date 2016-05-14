Estimate pi
-----------

A program to approximate the numerical value of pi.

Uses the following series: pi = 4 * sum[(-1)^n/2n-1]

Options
-------
This uses recursion, which is fast but may be limited by the stack size of the JVM.

Running on Linux the maximum number of terms in the series, the value (n), is 9,000.
This gives a reasonable estimate (to about 3 decimal places).

If you require more accuracy you can increase the stack size using the Java option:
-Xss and select a value that allows you to increase the value of n.

You may need to experiment to find the optimal solution for your environment.

Build
-----
This project is a Maven project in Eclipse IDE.
If you are not familiar with Eclipse, visit the website for instructions.
To build the project select the pom.xml file in the project explorer and select
Run As.. Maven Build.
If you need to set the Maven target select: clean verify
You can run the application from Eclipse, or download the jar file.