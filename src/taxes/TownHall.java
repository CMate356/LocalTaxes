package taxes;

import java.util.Vector;

public class TownHall {
	private  Vector <ITaxPayer> taxPayers;
	private double s;
	public TownHall() {
		this.taxPayers=new Vector<>();
	}
	public boolean add(ITaxPayer e) {
		return taxPayers.add(e);
	}

	public void remove(int index) {
		if (index >= 0 && index < taxPayers.size())
			taxPayers.remove(index);
	}

	public double computeTotalTax() {
		s=0;
		for ( ITaxPayer payer : taxPayers) {
			s = s + payer.computeTax();
		}
		return s;
	}
	public double computeProgressiveTotalTax() {
		s=0;
		for ( ITaxPayer payer : taxPayers) {
			s = s + payer.computeTaxWithBrackets();
		}
		return s;
	}
}
