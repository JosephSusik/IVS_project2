/*******************************************************************
 * Project name: Calculator
 * File: stddev.java
 * Date: 23.4.2020
 * Authors: xsusik00, xsucha17
 *
 *******************************************************************/
/**
 * @file stddev.java
 *
 * @brief standard deviation class
 * @author xsusik00
 * @author xsucha17
 *
 */

package gradle;

import java.util.Scanner;
import java.util.Vector;

import static gradle.libs.math.*;

/**
 * Class Standard deviation
 */
public class stddev {
    /**
     * Method stddev calculates standard deviation from input and prints result to output
     *
     * @param args the command line argument
     * @throws IllegalOptionException
     */
    public static void main(String[] args) throws IllegalOptionException {

        Vector<Double> vec_tor = new Vector<>();
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0, standardDeviation = 0.0;

        // Adding numbers from file into the vector
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                vec_tor.add(scanner.nextDouble());
            }
        }

        // number of numbers in file
        int length = vec_tor.size();

        // Adding all numbers together
        for(double num : vec_tor) {
            sum = adding(sum, num);
        }

        // (sum/length)
        double mean = division(sum, length);

        // [(num[1]-mean)^2 + (num[2]-mean)^2 + ... + (num[length-1]-mean)^2] = x
        for(double num: vec_tor) {
            double numMean = subtraction(num, mean);
            double mathPow = power(numMean, 2);
            standardDeviation = adding(standardDeviation, mathPow);
        }

        // √( x / (length-1) )
        double SD = root(division(standardDeviation, subtraction(length,1)), 2);

        System.out.format("Standard Deviation = %.6f", SD);
    } //end of main method
} //end of stddev class

/*** End of file stddev.java ***/