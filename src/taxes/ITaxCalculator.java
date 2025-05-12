package taxes;

public interface ITaxCalculator {

	double computeTax(double area);
	double computeTax(double area, double rate);
	}