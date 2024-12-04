package openclosed.problem;

import java.util.List;

public class OrderProcessor {
	public static void main(String[] args) {
		CostCalculatorService costCalculatorService = new CostCalculatorService();
		MobilePhone mobilePhone = new MobilePhone(9800);
		Laptop laptop = new Laptop(54000);
		Tablet tablet = new Tablet(7200);
		List<Object> products = List.of(mobilePhone, laptop, tablet);
		double totalCost = costCalculatorService.calculateCost(products);
		InvoiceGeneratorService costDisplayService = new InvoiceGeneratorService();
		costDisplayService.generateInvoice(totalCost);
	}
}
