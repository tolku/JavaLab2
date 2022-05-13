package integrals;

public class TrapezoidMethod extends IntegralAlgorithm {
    @Override
    public void calculateIntegral() {
        double h = ((b) - (a)) / n; //wysokosc trapezu
        double podstA = function.getValue(a);
        double podstB;
        for (int i = 1; i <= n; ++i){
            podstB = function.getValue(a+h*i);
            sum += podstA + podstB;
            podstA = podstB;
        }
        sum *= 0.5 * h;
    }

    @Override
    public String toString() {
        return "Trapezoid method ";
    }
}
