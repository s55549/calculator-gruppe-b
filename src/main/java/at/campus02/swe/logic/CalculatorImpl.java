package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        double b = pop();

        switch (op) {
            case add: {
                double a = pop();
                return a + b;
            }
            case sub: {
                double a = pop();
                return a - b;
            }
            case div: {
                double a = pop();
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            }
            case mul: {
                double a = pop();
                return a * b;
            }
            case mod: {
                double a = pop();
                double c = a % b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                if (Double.isNaN(c))
                    throw new CalculatorException("Invalid input for mod operation");
                return c;
            }
            case sin: {
                double sinResult = Math.sin(b);
                if (Double.isNaN(sinResult))
                    throw new CalculatorException("Invalid input for sin operation");
                return sinResult;
            }
            case cos: {
                double cosResult = Math.cos(b);
                if (Double.isNaN(cosResult))
                    throw new CalculatorException("Invalid input for cos operation");
                return cosResult;
            }
            case dotproduct: {
                int n = (int) b;
                if (n <= 0)
                    throw new CalculatorException("Invalid input for dot product operation");

                if (stack_.size() < 2 * n)
                    throw new CalculatorException("Not enough elements in the stack for dot product operation");

                double[] vector1 = new double[n];
                for (int i = 0; i < n; i++) {
                    vector1[i] = pop();
                }

                double[] vector2 = new double[n];
                for (int i = n; i < n * 2; i++) {
                    vector2[i - n] = pop();
                }

                double dotProduct = 0;
                for (int i = 0; i < n; i++) {
                    dotProduct += vector1[i] * vector2[i];
                }

                return dotProduct;
            }
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

}
