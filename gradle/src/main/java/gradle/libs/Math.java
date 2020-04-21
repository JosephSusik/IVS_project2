package gradle.libs;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Math {
    
//	ADDING    
    public static int adding(int opp_1, int opp_2){
        return (opp_1 + opp_2);
    };

    public static double adding(double opp_1, double opp_2){
        return (opp_1 + opp_2);
    };
    
    public static double adding(double opp_1, int opp_2){
        return (opp_1 + opp_2);
    };
    
    public static double adding(int opp_1, double opp_2){
        return (opp_1 + opp_2);
    };
    
    public static float adding(float opp_1, float opp_2){
        return (opp_1 + opp_2);
    };
    
//	SUBTRACTION
    public static int subtraction(int opp_1, int opp_2){
        return (opp_1 - opp_2);
    };

    public static double subtraction(double opp_1, double opp_2){
        return (opp_1 - opp_2);
    };

    public static double subtraction(int opp_1, double opp_2){
        return (opp_1 - opp_2);
    };
    
    public static double subtraction(double opp_1, int opp_2){
        return (opp_1 - opp_2);
    };
    
    public static float subtraction(float opp_1, float opp_2){
        return (opp_1 - opp_2);
    };
    
//	MULTIPLICATION
    public static int multiplication(int opp_1, int opp_2){
        return (opp_1 * opp_2);
    };

    public static double multiplication(double opp_1, double opp_2){
        return (opp_1 * opp_2);
    };
    
    public static double multiplication(int opp_1, double opp_2){
        return (opp_1 * opp_2);
    };
    
    public static double multiplication(double opp_1, int opp_2){
        return (opp_1 * opp_2);
    };
    
    public static float multiplication(float opp_1, float opp_2){
        return (opp_1 * opp_2);
    };
    
//	DIVISION
    public static double division(double opp_1, double opp_2)  {
     //   if (opp_2 == 0.0)
     //      Systen.error.println("");
     //   else
            return (opp_1 / opp_2);
    };
    
    public static double division(double opp_1, int opp_2) /*throws IllegalOptionException*/ {
       // if (opp_2 == 0.0)
       //   throw new IllegalOptionException();
       // else
            return (opp_1 / opp_2);
    };
    
    public static double division(int opp_1, double opp_2) /*throws IllegalOptionException*/ {
      //  if (opp_2 == 0.0)
      //      throw new IllegalOptionException();
      //  else
            return (opp_1 / opp_2);
    };
    
    public static float division(float opp_1, float opp_2) {
	    return (opp_1 / opp_2);
    };
    
//	FACTORIAL
    public static int factorial(double opp_1) /*throws IllegalOptionException*/ {
        int result = 1;
    /*  if (opp_1 != (int)opp_1 || opp_1 < 0)
          throw new IllegalOptionException();
        else if (opp_1 > 0) {*/
            while (opp_1 > 0) {
                result *= opp_1;
                opp_1--;
           // };
        };
        return (result);
    };

//	POWER
    public static double power(double opp_1, double opp_2) /*throws IllegalOptionException*/ {
       // if (opp_1 ==0 && opp_2==0)
       //     throw new IllegalOptionException();
       // else if (opp_2 != (int)opp_2 || opp_2 < 0)
       //     throw new IllegalOptionException();
       // else
            return (pow(opp_1, opp_2));
    };

    public static double power(double opp_1, int opp_2) /*throws IllegalOptionException*/ {
       // if (opp_1 ==0 && opp_2==0)
       //     throw new IllegalOptionException();
       // else if (opp_2 < 0)
       //     throw new IllegalOptionException();
       // else
            return (pow(opp_1, opp_2));
    };
   
    public static double power(int opp_1, double opp_2) /*throws IllegalOptionException*/ {
        //if (opp_1 ==0 && opp_2==0)
        //    throw new IllegalOptionException();
       // else if (opp_2 != (int)opp_2 || opp_2 < 0)
        //    throw new IllegalOptionException();
       // else
            return (pow(opp_1, opp_2));
    };

//	ROOT    
    public static double root(double opp_1, int opp_2) /*throws IllegalOptionException*/ {
      //  if (opp_2 == 0)
       //     throw new IllegalOptionException();
      //  else if ((opp_2 % 2) == 0 && opp_1 < 0)
      //      throw new IllegalOptionException();
     //   else
            return (pow(opp_1, (1.0 / opp_2)));
    };

    public static double root(int opp_1, int opp_2) /*throws IllegalOptionException*/ {
      //  if (opp_2 == 0)
      //      throw new IllegalOptionException();
     //   else if ((opp_2 % 2) == 0 && opp_1 < 0)
      //      throw new IllegalOptionException();
      //  else
            return (pow(opp_1, (1.0 / opp_2)));
    };

//	LOGARITHM
    public static double logarithm(double opp_1, double opp_2) /*throws IllegalOptionException*/ {
       /* if (opp_1 <= 1 || opp_2 <= 0)
            throw new IllegalOptionException();*/
        return (log(opp_2) / log(opp_1));
    }

    public static class IllegalOptionException extends Throwable {
        public IllegalOptionException(){
        }
    }
};
