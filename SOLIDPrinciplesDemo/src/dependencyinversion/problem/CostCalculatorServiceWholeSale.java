package dependencyinversion.problem;

import java.util.List;

public class CostCalculatorServiceWholeSale implements ICostCalculatorService {

	static final int DISCOUNT_PROVIDED = 500;
	
	@Override
	public double calculateCost(List<AvailableProduct> products) {
		double totalCost = 0;

		for (AvailableProduct product : products) {
			totalCost += product.calculateCost() - DISCOUNT_PROVIDED;
		}
		return totalCost;
	}

}
