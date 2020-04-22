package gradle.libs;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Math {

    public static double adding(double opp_1, double opp_2){
        return (opp_1 + opp_2);
    }

    public static double subtraction(double opp_1, double opp_2){
        return (opp_1 - opp_2);
    }

    public static double multiplication(double opp_1, double opp_2){
        return (opp_1 * opp_2);
    }

    public static double division(double opp_1, double opp_2) throws IllegalOptionException {
        if (opp_2 == 0.0)
            throw new IllegalOptionException();
        else
            return (opp_1 / opp_2);
    }

    public static int factorial(double opp_1) throws IllegalOptionException {
        int result = 1;
        if (opp_1 != (int)opp_1 || opp_1 < 0)
            throw new IllegalOptionException();
        else if (opp_1 > 0) {
            while (opp_1 > 0) {
                result *= opp_1;
                opp_1--;
            }
        }
        return (result);
    }

    public static double power(double opp_1, double opp_2) throws IllegalOptionException {
        if (opp_1 == 0 && opp_2 == 0)
            throw new IllegalOptionException();
        else if (opp_2 != (int)opp_2 || opp_2 < 0)
            throw new IllegalOptionException();
        else
            return (pow(opp_1, opp_2));
    }

    public static double root(double opp_1, int opp_2) throws IllegalOptionException {
        if (opp_2 == 0)
            throw new IllegalOptionException();
        else if ((opp_2 % 2) == 0 && opp_1 < 0)
            throw new IllegalOptionException();
        else
            return (pow(opp_1, (1.0 / opp_2)));
    }

    public static double logarithm(double opp_1, double opp_2) throws IllegalOptionException {
        if (opp_1 <= 1 || opp_2 <= 0)
            throw new IllegalOptionException();
        return (log(opp_2) / log(opp_1));
    }

    public static class IllegalOptionException extends Throwable {
        public IllegalOptionException(){
        }
    }
}
