package com.example;

public class Calculator {
    private int result;
    private Logger logger;

    public Calculator(Logger logger) {
        this.result = 0;
        this.logger = logger;
    }

    public void add(int a) {
        this.result = Calc.add(this.result, a);
        logger.log("Add(" + a + "): result = " + this.result);
    }

    public void subtract(int a) {
        this.result = Calc.subtract(this.result, a);
        logger.log("Subtract(" + a + "): result = " + this.result);
    }

    public void multiply(int a) {
        this.result = Calc.multiply(this.result, a);
        logger.log("Multiply(" + a + "): result = " + this.result);
    }

    public void divide(int a) {
        try {
            this.result = Calc.divide(this.result, a);
            logger.log("Divide(" + a + "): result = " + this.result);
        } catch (IllegalArgumentException e) {
            logger.log("Divide(" + a + "): error = division by zero");
            throw new IllegalArgumentException("division error", e);
        }
    }

    public int getResult() {
        return this.result;
    }

    public void reset() {
        this.result = 0;
        logger.log("Reset(): result = 0");
    }
}
