package taxes;

public class IsWithinBrackets implements IIsWithinBrackets {
	private final double[][] brackets;
    private final ITaxCalculator taxCalculator;

    public IsWithinBrackets(double[][] brackets, ITaxCalculator taxCalculator) {
        this.brackets = brackets;
        this.taxCalculator = taxCalculator;
    }

    @Override
    public double computeTaxWithBrackets(double area) {
        double tax = 0;
        double previousLimit = 0;
        
        if (area > brackets[0][0]) {
            tax += taxCalculator.computeTax(brackets[0][0] - previousLimit, brackets[0][1]);
            previousLimit = brackets[0][0];
        } else {
            return taxCalculator.computeTax(area - previousLimit, brackets[0][1]);
        }

        if (area > brackets[1][0]) {
            tax += taxCalculator.computeTax(brackets[1][0] - previousLimit, brackets[1][1]);
            previousLimit = brackets[1][0];
        } else {
            return tax + taxCalculator.computeTax(area - previousLimit, brackets[1][1]);
        }

        if (area > brackets[2][0]) {
            tax += taxCalculator.computeTax(brackets[2][0] - previousLimit, brackets[2][1]);
            previousLimit = brackets[2][0];
        } else {
            return tax + taxCalculator.computeTax(area - previousLimit, brackets[2][1]);
        }

        tax += taxCalculator.computeTax(area - previousLimit, brackets[3][1]);

        return tax;
    }
}
