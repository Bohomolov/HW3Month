package calculator.blogic;

public class Blogic {
    private final String divinityByZero = "divide by zero";

    public double plus(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double minus(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double division(double firstNumber, double secondNumber) {
        if (secondNumber == 0.0) {
            throw new IllegalArgumentException(divinityByZero);
        }
        return firstNumber / secondNumber;
    }
}
