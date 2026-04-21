import Exceptions.InvalidInputException;
import Exceptions.NegativeNumberException;
import Exceptions.ZeroDivisionException;

public class BasicCalculator extends Calculator {
	private String lastOperation = "none";

	// Checked exception: invalid double input (NaN or Infinity).
	// Unchecked exception: negative values are restricted by business rule.
	private void validateDoubleInput(double a, double b) throws InvalidInputException {
		if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
			throw new InvalidInputException("Input must be a valid finite number.");
		}

		if (a < 0 || b < 0) {
			throw new NegativeNumberException("Negative numbers are not allowed.");
		}
	}

	private void validateIntInput(int a, int b) {
		if (a < 0 || b < 0) {
			throw new NegativeNumberException("Negative numbers are not allowed.");
		}
	}

	public String getLastOperation() {
		return lastOperation;
	}

	@Override
	public double add(double a, double b) throws InvalidInputException {
		// InvalidInputException is propagated to caller (handled in demo).
		validateDoubleInput(a, b);
		lastOperation = "add(double, double)";
		return a + b;
	}

	@Override
	public double subtract(double a, double b) throws InvalidInputException {
		validateDoubleInput(a, b);
		lastOperation = "subtract(double, double)";
		return a - b;
	}

	@Override
	public double multiply(double a, double b) throws InvalidInputException {
		validateDoubleInput(a, b);
		lastOperation = "multiply(double, double)";
		return a * b;
	}

	@Override
	public double divide(double a, double b) throws InvalidInputException, ZeroDivisionException {
		validateDoubleInput(a, b);
		// Checked exception thrown explicitly for divide-by-zero.
		if (b == 0.0d) {
			throw new ZeroDivisionException("Cannot divide by zero.");
		}

		lastOperation = "divide(double, double)";
		return a / b;
	}

	@Override
	public int add(int a, int b) {
		validateIntInput(a, b);
		lastOperation = "add(int, int)";
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		validateIntInput(a, b);
		lastOperation = "subtract(int, int)";
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		validateIntInput(a, b);
		lastOperation = "multiply(int, int)";
		return a * b;
	}

	@Override
	public int divide(int a, int b) throws ZeroDivisionException {
		validateIntInput(a, b);
		if (b == 0) {
			throw new ZeroDivisionException("Cannot divide by zero.");
		}

		lastOperation = "divide(int, int)";
		return a / b;
	}
}