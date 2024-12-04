package intefacesegregation.problem;

import java.util.List;

public class CostCalculatorService {

	public double calculateCost(List<AvailableProduct> products) {
		double totalCost = 0;

		for (AvailableProduct product : products) {
			totalCost += product.calculateCost();
		}
		return totalCost;
	}
}
