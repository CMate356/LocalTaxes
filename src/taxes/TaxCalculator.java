package taxes;

public class TaxCalculator implements ITaxCalculator {
	private double taxRate;
	public TaxCalculator(double taxRate) {
		this.taxRate=taxRate;
	}
	@Override
	public double computeTax(double area)
	{
        return area*taxRate;		
	}
	public double computeTax(double area, double rate) {
		return area * rate;
	}
}
