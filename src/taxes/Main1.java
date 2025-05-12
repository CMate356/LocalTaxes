package taxes;

import landowners.*;

public class Main1 {
    public static void main(String[] args) {
    	 double[][] customBrackets = {
    	            {10, 1},
    	            {30, 2},
    	            {70, 3},
    	            {Double.POSITIVE_INFINITY, 4}
    	        };
        ITaxCalculator region1Calculator = new TaxCalculator(1);
        
        LandOwner owner1 = new LandOwner();
        LandOwner owner2 = new LandOwner();

        owner1.add(new Rectangle(10, 5)); 
        owner1.add(new Parallelogram(3,2));       
        owner2.add(new Square(4));        
        owner2.add(new Triangle(6, 4));    
        IIsWithinBrackets helper = new IsWithinBrackets(customBrackets,region1Calculator);
        TaxPayer taxpayer1 = new TaxPayer(region1Calculator, owner1, helper); 
        TaxPayer taxpayer2 = new TaxPayer(region1Calculator, owner2, helper); 

        TownHall townHall = new TownHall();
        townHall.add(taxpayer1);
        townHall.add(taxpayer2);

       
        double totalTax = townHall.computeTotalTax();
        System.out.println("Total Tax Collected:" + totalTax);

        double totalTax2 = townHall.computeProgressiveTotalTax();
        System.out.println("Total Tax Collected:" + totalTax2);
       
    }
}
