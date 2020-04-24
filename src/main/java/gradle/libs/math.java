/*******************************************************************
 * Project name: Calculator
 * File: math.java
 * Date: 23.4.2020
 * Authors: xdudaj02
 *
 *******************************************************************/
/**
 * @file math.java
 *
 * @brief mathematical library for the calculator
 * @author xdudaj02
 *
 */

package gradle.libs;

import static java.lang.Math.log;
import static java.lang.Math.pow;

/**
 * Class math contains mathematical methods used by the calculator
 */
public class math {

    /**
     * Addition method
     *
     * @brief x + y
     * @param op_1 first operand of addition
     * @param op_2 second operand of addition
     * @return result of addition, sum of operands
     */
    public static double adding(double op_1, double op_2){
        return (op_1 + op_2);
    }

    /**
     * Subtraction method
     *
     * @brief x - y
     * @param op_1 first operand of subtraction
     * @param op_2 second operand of subtraction
     * @return result of subtraction, difference of operands
     */
    public static double subtraction(double op_1, double op_2){
        return (op_1 - op_2);
    }

    /**
     * Multiplication method
     *
     * @brief x * y
     * @param op_1 first operand of multiplication
     * @param op_2 second operand of multiplication
     * @return result of multiplication, product of operands
     */
    public static double multiplication(double op_1, double op_2){
        return (op_1 * op_2);
    }

    /**
     * Division method
     *
     * @brief x / y
     * @param op_1 first operand of division
     * @param op_2 second operand of division
     * @return result of division, quotient of operands
     * @throws IllegalOptionException if 'op_2' = '0'
     */
    public static double division(double op_1, double op_2) throws IllegalOptionException {
        if (op_2 == 0.0)
            throw new IllegalOptionException();
        else
            return (op_1 / op_2);
    }

    /**
     * Factorial method
     *
     * @brief x! = x * x-1 * x-2 * ... * 3 * 2 * 1
     * @param op_1 first operand of factorial function
     * @return result of factorial function
     * @throws IllegalOptionException if 'op_1' is not integer or 'op_1' is negative
     */
    public static int factorial(double op_1) throws IllegalOptionException {
        int result = 1;
        if (op_1 != (int) op_1 || op_1 < 0)
            throw new IllegalOptionException();
        else if (op_1 > 0) {
            while (op_1 > 0) {
                result *= op_1;
                op_1--;
            }
        }
        return (result);
    }

    /**
     * Power method
     *
     * @brief x to power of y = x ^ y
     * @param op_1 first operand of power power function (base)
     * @param op_2 second operand of power function (exponent)
     * @return result of power function
     * @throws IllegalOptionException if any of operands are zero or if 'op_2' is not integer or is negative
     */
    public static double power(double op_1, double op_2) throws IllegalOptionException {
        if (op_1 == 0 && op_2 == 0)
            throw new IllegalOptionException();
        else if (op_2 != (int) op_2 || op_2 < 0)
            throw new IllegalOptionException();
        else
            return (pow(op_1, op_2));
    }

    /**
     * Root method
     *
     * @brief yth root of x
     * @param opp_1 first operand of root function (radicand)
     * @param opp_2 second operand of root function (degree)
     * @return result of root function
     * @throws IllegalOptionException if degree is zero or if degree is even and radicand is negative
     */
    public static double root(double opp_1, int opp_2) throws IllegalOptionException {
        if (opp_2 == 0)
            throw new IllegalOptionException();
        else if ((opp_2 % 2) == 0 && opp_1 < 0)
            throw new IllegalOptionException();
        else
            return (pow(opp_1, (1.0 / opp_2)));
    }

    /**
     * Logarithm function
     *
     * @param opp_1 first operand of logarithm function (base)
     * @param opp_2 second operand of logarithm function (antilogarithm)
     * @return result of logarithm function
     * @throws IllegalOptionException if base is non positive or if antilogarithm is negative
     */
    public static double logarithm(double opp_1, double opp_2) throws IllegalOptionException {
        if (opp_1 <= 1 || opp_2 <= 0)
            throw new IllegalOptionException();
        return (log(opp_2) / log(opp_1));
    }

    /**
     * Class Illegal option
     *
     * @brief is thrown when illegal values are supplied to mathematical functions
     */
    public static class IllegalOptionException extends Throwable {
        public IllegalOptionException(){
        }
    }
} //end of class math

/*** End of file math.java ***/
