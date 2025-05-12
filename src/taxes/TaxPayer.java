package taxes;
import landowners.LandOwner;

public class TaxPayer implements ITaxPayer{
private LandOwner payer;
private ITaxCalculator taxCalculator;
private IIsWithinBrackets isWithinBrackets;

public TaxPayer(ITaxCalculator taxCalculator,LandOwner payer,IIsWithinBrackets helper) {
	this.taxCalculator=taxCalculator;
	this.isWithinBrackets=helper;
	this.payer=payer;
}

@Override
public double computeTaxWithBrackets(){
	double area= payer.getTotalArea();
	return isWithinBrackets.computeTaxWithBrackets(area);	
}

@Override
public double computeTax() {
		double area= payer.getTotalArea();
		return taxCalculator.computeTax(area);
}
}
