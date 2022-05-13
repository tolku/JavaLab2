package integrals;

import functions.Function;

public abstract class IntegralAlgorithm {
    protected double a;
    protected double b;
    protected int n;
    protected double sum;
    protected Function function;

    public double getIntegral(){
        return sum;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    public int getN(){
        return n;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public abstract void calculateIntegral();

    public abstract String toString();

    public double Sum(){
        return sum;
    }
}
