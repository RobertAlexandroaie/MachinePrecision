/**
 * 
 */
package model;

import java.util.Random;

/**
 * @author Robert
 */
public class MachinePrecision {

    public static double getMachinePrecision() {
	double machinePrecision = 0.0;
	double unity = 1.0;
	int pow = 1;
	boolean isOK = (machinePrecision + unity) != unity;

	while (!isOK) {
	    machinePrecision = Math.pow(10, -pow);
	    double unityPlusPrecision = machinePrecision + unity;
	    isOK = unityPlusPrecision == unity;
	    pow++;
	}
	pow--;
	pow--;
	machinePrecision = Math.pow(10, -pow);

	return machinePrecision;
    }

    public static double[] associativeParam() {
	double x = 1.0;
	double y = getMachinePrecision();

	double sol[] = new double[2];

	double left = x + y;
	left += y;

	double right = y + y;
	right += x;

	sol[0] = left;
	sol[1] = right;
	return sol;
    }

    public static double[] mulAssociativeParam() {
	Random random = new Random();

	double sol[] = new double[3];
	Double x = random.nextDouble();
	Double y = getMachinePrecision();
	double left = 1.0;

	double right = 1.1;

	boolean isOK = left != right;

	while (!isOK) {
	    x = random.nextDouble();
	    left = x * y;
	    left *= y;
	    right = y * y;
	    right *= x;
	    isOK = left != right;
	}

	sol[0] = x;
	sol[1] = left;
	sol[2] = right;

	return sol;
    }
}
