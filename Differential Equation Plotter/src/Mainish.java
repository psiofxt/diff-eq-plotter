import java.util.ArrayList;
import java.util.Iterator;

public class Mainish {

	public static void main(String args[]) {
		Equation test = new Equation(.3, 1.2);
		Equation test2 = new Equation(0, 0);

		System.out.println("Value of c = " + test.getC());

		ArrayList<Double> values1 = new ArrayList<>();
		ArrayList<Double> values2 = new ArrayList<>();
		double inc = -2;
		for (int i = -200; i < 200; i++) {
			values1.add(test.setEquationReturn(inc));
			inc = inc + .01;
		}

		inc = -2;
		for (int i = -200; i < 200; i++) {
			values2.add(test2.setEquationReturn(inc));
			inc = inc + .01;
		}

		Iterator it = values1.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Grapher one = new Grapher(values1, values2);
		one.init();
	}

}
