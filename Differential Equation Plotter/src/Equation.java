public class Equation {
	double c;
	double equation1, equation2;
	double x, y;

	/*
	 * Equation(double m, double ii){ mew = m; i = ii; equation =
	 * (Math.pow(Math.E, mew)) * (c1*Math.cos(i) + c2*Math.sin(i)); }
	 */

	Equation(double x, double y) {
		this.x = x;
		equation1 = (.3333333333) * Math.pow(Math.E, 2 * x)
				+ Math.pow(Math.E, -4 * x);
		c = (y - (.33333333333333) * Math.pow(Math.E, 2 * x))
				/ Math.pow(Math.E, -4 * x);
	}

	public double getC() {
		return c;
	}

	/*
	 * Value of c has been determined to come to the solution of the IVP. x is
	 * then incremented by a step size to determine corresponding values of y.
	 * These new (x,y) points will be plotted.
	 */
	public void setEquation2() {
		double increment = x;
		for (int i = 0; i < 20; i++) {
			double temp = (.33333333333333) * Math.pow(Math.E, 2 * increment)
					+ c * Math.pow(Math.E, -4 * increment);
			System.out.println("Value of y = " + temp + " at x = " + increment);
			increment = increment + 1;
		}
	}

	public double setEquationReturn(double inc) {
		double temp = (.33333333333333) * Math.pow(Math.E, 2 * inc) + c
				* Math.pow(Math.E, -4 * inc);
		return temp;
	}

	public double getEquation2() {
		return equation2;
	}
}
