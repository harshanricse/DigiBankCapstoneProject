package dependencyinversion.solution;

import java.util.List;

public class CostCalculatorServiceRetail implements ICostCalculatorService {

	public double calculateCost(List<AvailableProduct> products) {
		double totalCost = 0;

		for (AvailableProduct product : products) {
			totalCost += product.calculateCost();
		}
		return totalCost;
	}
}
