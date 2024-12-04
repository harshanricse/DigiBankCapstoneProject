package democode;

import java.util.List;

public class OrderProcessor {
	public static void main(String[] args) {
		CostCalculatorService costCalculator = new CostCalculatorService();
		MobilePhone mobilePhone = new MobilePhone(9800);
		Laptop laptop = new Laptop(54000);
		List<Object> products = List.of(mobilePhone, laptop);
		double totalCost = costCalculator.calculateCost(products);
		System.out.println("Total cost of order = " + totalCost);
	}
}
