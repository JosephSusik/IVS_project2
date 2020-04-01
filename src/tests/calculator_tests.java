package com.calculator_tests;

//libraries
import com.math_library.math;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.E;
import static org.junit.jupiter.api.Assertions.*;
import static com.math_library.math.*;


//class, beginning of tests
public class calculator_tests{

    //static virtual object created
    //private static final Math mathematics = new Math();

    private static final double DELTA = 1e-5;

    //addition tests
    @Test
    public void Adding_tests(){
        
        //assert equal
        assertEquals(0, adding(0, 0));
        assertEquals(0, adding(-1, 1));
        assertEquals(10, adding(10, 0));
        assertEquals(-30, adding(-20, -10));
        assertEquals(-1, adding(12, -13));
        assertEquals(200000, adding(100000, 100000));
        assertEquals(10, adding(4.25, 5.75));
        assertEquals(-2.2345, adding(-1.4986, -0.7359), DELTA);

        //assert not equal
        assertNotEquals(-2, adding(-2, -2));
        assertNotEquals(1000000, adding(100000, 100000));
        assertNotEquals(-2.5, adding(-1.5, 2));
        assertNotEquals(123, adding(123, 1));
        assertNotEquals(3.4598, adding(3.125, 5.649));
    }

    //subtraction tests
    @Test
    public void Subtraction_tests(){

        //assert equal
        assertEquals(0, subtraction(0, 0));
        assertEquals(0, subtraction(2, 2));
        assertEquals(-10, subtraction(-45, -35));
        assertEquals(30, subtraction(20, -10));
        assertEquals(-9000, subtraction(1000, 10000));
        assertEquals(0, subtraction(10000, 10000));
        assertEquals(4.06, subtraction(8.23, 4.17), DELTA);
        assertEquals(-4.2469, subtraction(-10.2345, -5.9876), DELTA);

        //assert not equal
        Assertions.assertNotEquals(0, subtraction(2, 3));
        Assertions.assertNotEquals(-2, subtraction(-2, -2));
        Assertions.assertNotEquals(1000000, subtraction(100000, 100000));
        Assertions.assertNotEquals(-2.5, subtraction(-1.5, 2), DELTA);
        Assertions.assertNotEquals(123, subtraction(123, 1));
        Assertions.assertNotEquals(3.4598, subtraction(3.125, 5.649), DELTA);
    }

    //multiplication tests
    @Test
    public void Multiplication_tests(){
        
        //assert equal
        assertEquals(0, multiplication(0, 0));
        assertEquals(6, multiplication(2, 3));
        assertEquals(-40, multiplication(-10, 4));
        assertEquals(200, multiplication(-20, -10));
        assertEquals(-13104, multiplication(-84, 156));
        assertEquals(0, multiplication(100000, 0));
        assertEquals(19.6875, multiplication(2.25, 8.75), DELTA);
        assertEquals(-3.86508, multiplication(-12.468, 0.31), DELTA);

        //assert not equal
        assertNotEquals(1000000, multiplication(1000000, 0));
        assertNotEquals(-2.5, multiplication(-1.5, 2), DELTA);
        assertNotEquals(1, multiplication(123, 1));
        assertNotEquals(3.4598, multiplication(3.125, 5.649), DELTA);

    }

    //division tests
    @Test
    public void Division_tests() throws IllegalOptionException {

        //assert exception thrown
        IllegalOptionException thrown = assertThrows(
                IllegalOptionException.class,
                () -> division(5, 0));

        //assert equal
        assertEquals(0, division(0, 5));
        assertEquals(1, division(3, 3));
        assertEquals(-2, division(-8, 4));
        assertEquals(2, division(-20, -10));
        assertEquals(-0.8, division(-100, 125), DELTA);
        assertEquals(21.25, division(4.25, 0.2), DELTA);
        assertEquals(-0.25714, division(2.25, -8.75), DELTA);

        //should not equal
        assertNotEquals(1, division(2, 3));
        assertNotEquals(-0.5, division(-100, 250), DELTA);
        assertNotEquals(21.2, division(4.25, 0.2), DELTA);
        assertNotEquals(12.56, division(2.25, -8.75), DELTA);
    }

    //factorial tests
    @Test
    public void Factorial_tests() throws IllegalOptionException {

        //assert exception thrown
        IllegalOptionException thrown_0 = assertThrows(
                IllegalOptionException.class,
                () -> factorial(2.5));

        IllegalOptionException thrown_1 = assertThrows(
                IllegalOptionException.class,
               () -> factorial(-5));

        //assert equal
        assertEquals(1, factorial(0));
        assertEquals(120, factorial(5));
        assertEquals(3628800, factorial(10));

        //should not equal
        assertNotEquals(0, factorial(0));
        assertNotEquals(0, factorial(1));
        assertNotEquals(8, factorial(3));
    }


    //power tests
    @Test
    public void Power_tests() throws IllegalOptionException {

        //assert exception thrown
        IllegalOptionException thrown_0 = assertThrows(
                IllegalOptionException.class,
                () -> power(0, 0));

        IllegalOptionException thrown_1 = assertThrows(
                IllegalOptionException.class,
                () -> power(5, 0.5));

        IllegalOptionException thrown_2 = assertThrows(
                IllegalOptionException.class,
                () -> power(2.5, -4.89));

        IllegalOptionException thrown_3 = assertThrows(
                IllegalOptionException.class,
                () -> power(2, -3));

        //assert equal
        assertEquals(0, power(0, 5));
        assertEquals(16, power(4, 2));
        assertEquals(4096, power(-8, 4));
        assertEquals(-8000, power(-20, 3));
        assertEquals(1, power(459153, 0));
        assertEquals(20.25, power(4.5, 2), DELTA);

        //should not equal
        assertNotEquals(1, power(0, 4), DELTA);
        assertNotEquals(8, power(4, 2), DELTA);
        assertNotEquals(-1000, power(-2, 4), DELTA);
        assertNotEquals(-80025, power(-20, 3), DELTA);
    }

    //root tests
    @Test
    public void Root_tests() throws IllegalOptionException {

        //assert exception thrown
        IllegalOptionException thrown_0 = assertThrows(
                IllegalOptionException.class,
                () -> root(3, 0));

        IllegalOptionException thrown_1 = assertThrows(
                IllegalOptionException.class,
                () -> root(-16, 2));

        //assert equal
        assertEquals(2, root(8, 3));
        assertEquals(2.25, root(11.390625, 3));
        assertEquals(3, root(729, 6));
        assertEquals(2, root(8192, 13));

        //should not equal
        assertNotEquals(1, root(2, 4), DELTA);
        assertNotEquals(2, root(1, 2), DELTA);
        assertNotEquals(-1000, root(2000, 4), DELTA);
        assertNotEquals(20, root(20, 3), DELTA);
    }

    //logarithm tests
    @Test
    public void Logarithm_tests() throws IllegalOptionException{

        //assert exception thrown
        IllegalOptionException thrown_0 = assertThrows(
                IllegalOptionException.class,
                () -> logarithm(0, 0));

        IllegalOptionException thrown_1 = assertThrows(
                IllegalOptionException.class,
                () -> logarithm(-10, 10));

        IllegalOptionException thrown_2 = assertThrows(
                IllegalOptionException.class,
                () -> logarithm(0, 10));

        IllegalOptionException thrown_3 = assertThrows(
                IllegalOptionException.class,
                () -> logarithm(1, 10));

        IllegalOptionException thrown_4 = assertThrows(
                IllegalOptionException.class,
                () -> logarithm(2, 0));

        IllegalOptionException thrown_5 = assertThrows(
                IllegalOptionException.class,
                () -> logarithm(10, -2));

        IllegalOptionException thrown_6 = assertThrows(
                IllegalOptionException.class,
                () -> logarithm(-1, -1));

        //assert equal
        assertEquals(0, logarithm(2, 1));
        assertEquals(1, logarithm(4.5, 4.5));
        assertEquals(2, logarithm(10, 100));
        assertEquals(3, logarithm(16, 4096));
        assertEquals(2, logarithm(E, 7.38909), DELTA);

        //assert not equal
        assertNotEquals(2, logarithm(4, 4));
        assertNotEquals(8, logarithm(4, 2));
        assertNotEquals(4, logarithm(2, 4));
        assertNotEquals(2, logarithm(100, 10));
        assertNotEquals(10, logarithm(1.01, 0.01));
    }
}
