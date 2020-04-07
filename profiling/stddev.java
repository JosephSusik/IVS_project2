package com.mat_library;

import static com.math_library.math;


public class stddev {

    public static void main(String[] args) {
        double[] numArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 		// nase nacitane cisla
        double SD = calculateSD(numArray); 				// ulozenie nacitanej odchylky

        System.out.format("Standard Deviation = %.6f", SD);
    }

    public static double calculateSD(double numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;

// pocet cisel, ktore nacitame z pola 
 	int length = numArray.length;

// Spocitame vsetky cisla z pola spolu
        for(double num : numArray) {
	    sum = adding(sum, num);
        }

// Hodnotu vsetkych cisiel dohomady vydelime poctom cisel a ulozime do premennej mean
	double mean = division(sum, length);

// Od kazdeho jedneho cisla z pola odratame mean, umocnime to na 2, spocitame vsetky umocnene cisla dohromady a ulozime to do premennej standarDeviation
        for(double num: numArray) {
	    double numMean = subtraction(num, mean);
	    double mathPow = power(numMean, 2);
	    standardDeviation = adding(standardDeviation, mathPow);

	}

// hodnotu v premennej standarDeviation vydelime poctom cisel, ktore nam boli zadane -1, odmocnime a vratime vyslednu hodnotu
  	int helpLength = subtraction(length-1);
	double helpRoot = division(standardDeviation, helpLength);
	return root(helpRoot, 2);      

    }
}
