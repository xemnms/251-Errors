package com.calculator.galindon.service;

import com.calculator.galindon.exception.InvalidInputException_Galindon;
import com.calculator.galindon.exception.NegativeResultException_Galindon;


public class Calculator_Galindon {

    public double add(double a, double b) throws InvalidInputException_Galindon {
        validate(a, b);
        return a + b;
    }

    public double subtract(double a, double b)
            throws InvalidInputException_Galindon, NegativeResultException_Galindon {

        validate(a, b);

        double result = a - b;

        if (result < 0) {
            throw new NegativeResultException_Galindon("Result cannot be negative");
        }

        return result;
    }

    public double multiply(double a, double b) throws InvalidInputException_Galindon {
        validate(a, b);
        return a * b;
    }

    public double divide(double a, double b)
            throws InvalidInputException_Galindon {

        validate(a, b);

        if (b == 0) {
            throw new InvalidInputException_Galindon("Cannot divide by zero");
        }

        return a / b;
    }

    private void validate(double a, double b)
            throws InvalidInputException_Galindon {

        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new InvalidInputException_Galindon("Invalid number input");
        }
    }
}