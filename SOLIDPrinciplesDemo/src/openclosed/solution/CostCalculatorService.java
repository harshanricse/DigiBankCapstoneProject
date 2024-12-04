package openclosed.solution;

import java.util.List;

public class CostCalculatorService {

	public double calculateCost(List<Product> products) {
		double totalCost = 0;

		for (Product product : products) {
			totalCost += product.calculateCost();
		}
		return totalCost;
	}
}
