package pl.retsuz;

import functions.Function;
import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import integrals.IntegralAlgorithm;
import integrals.MonteCarlo;
import integrals.TrapezoidMethod;

public class Main {

    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithm;

    protected static IntegralAlgorithm algorithm2;

    public static void main(String[] args) {

        functionBuilder = new CosineExampleBuilder();
        givenExample = functionBuilder.build();

        algorithm = new MonteCarlo();
        ConsoleInteraction.gatherInfo();
        ConsoleInteraction.setParameters(algorithm);

        algorithm2 = new TrapezoidMethod();
        ConsoleInteraction.gatherInfo();
        ConsoleInteraction.setParameters(algorithm2);

        algorithm.setFunction(givenExample);
        algorithm.calculateIntegral();

        algorithm2.setFunction(givenExample);
        algorithm2.calculateIntegral();

        double trapezoidIntegral = algorithm2.getIntegral();
        double monteIntegral = algorithm.getIntegral();

        ConsoleInteraction.displaySolutions(algorithm);
        ConsoleInteraction.displaySolutions(algorithm2);

        ConsoleInteraction.displayExactIntegral(algorithm, givenExample);
        ConsoleInteraction.displayExactIntegral(algorithm2, givenExample);

        double exactIntegral = givenExample.getExactIntegralValue(algorithm.getB()) - givenExample.getExactIntegralValue(algorithm.getA());
        double monteError = Math.abs(monteIntegral - exactIntegral);
        double trapError = Math.abs(trapezoidIntegral - exactIntegral);
        System.out.println("Exact result " + exactIntegral);
        System.out.println("Monte Carlo method error " + monteError);
        System.out.println("Trapezoid method error " + trapError);
    }
}
