package pl.retsuz;

import functions.Function;
import integrals.IntegralAlgorithm;

import java.util.*;

public class ConsoleInteraction {
    private static double a, b;
    private static int n;

    static Scanner scan = new Scanner(System.in);

    public static void displaySolutions(IntegralAlgorithm s) {
        System.out.println("Result for " + s.toString() + "equals to " + s.Sum());
    }

    public static void gatherInfo() {
        System.out.println("Set the start starting point");
        a = scan.nextDouble();
        System.out.println("Set the ending starting point");
        b = scan.nextDouble();
        System.out.println("Set the n parameter");
        n = scan.nextInt();
    }

    public static void setParameters(IntegralAlgorithm s) {
        s.setA(a);
        s.setB(b);
        s.setN(n);
    }

    public static double displayExactIntegral(IntegralAlgorithm s, Function givenExample) {
        return givenExample.getExactIntegralValue(s.getB()) - givenExample.getExactIntegralValue(s.getA());
    }
}
