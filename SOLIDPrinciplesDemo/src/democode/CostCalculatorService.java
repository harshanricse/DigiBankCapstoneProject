package democode;

import java.util.List;

public class CostCalculatorService {

	public double calculateCost(List<Object> products) {
		double totalCost = 0;

		for (Object product : products) {
			if (product instanceof MobilePhone) {
				totalCost += (double)(((MobilePhone) product).getCost() * (100 - MobilePhone.DISCOUNT)) / 100;
			}
			if (product instanceof Laptop) {
				totalCost += (double)(((Laptop) product).getCost() * (100 - Laptop.DISCOUNT)) / 100;
			}
		}
		return totalCost;
	}
}
