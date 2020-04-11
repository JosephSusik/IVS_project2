package gradle;

import gradle.libs.Math;
import java.util.*;

public class Stddev {

    public static void main(String[] args) {
       
	Vector<Double> vec_tor = new Vector<Double>();

	Scanner scanner = new Scanner(System.in);

	while (scanner.hasNext()) {

                        if (scanner.hasNextDouble()) {

                                vec_tor.add(scanner.nextDouble());
                        }
        }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        double sum = 0.0, standardDeviation = 0.0;

// number of numbers in file 
 	int length = vec_tor.size(); 
	
// Adding all numbers together
        for(double num : vec_tor) {
	    sum = Math.adding(sum, num);
	}

// (sum/length)
	double mean = Math.division(sum, length);

// [(num[1]-mean)^2 + (num[2]-mean)^2 + ... + (num[lenth-1]-mean)^2] = x
	for(double num: vec_tor) {
	    double numMean = Math.subtraction(num, mean);
	    double mathPow = Math.power(numMean, 2);
	    standardDeviation = Math.adding(standardDeviation, mathPow);

	}

// √( x / (length-1) ) 
	int helpLength = Math.subtraction(length,1);  
	double helpRoot = Math.division(standardDeviation, helpLength);
	double SD = Math.root(helpRoot, 2);      

	System.out.format("Standard Deviation = %.6f", SD);
    }
}
