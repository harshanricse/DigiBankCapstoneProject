package liskovsubstitution.problem;

import java.util.List;

public class OrderProcessor {
	public static void main(String[] args) {
		CostCalculatorService costCalculatorService = new CostCalculatorService();
		Product mobilePhone = new MobilePhone(9800);
		Product laptop = new Laptop(54000);
		Product tablet = new Tablet(15000);
		Product smartWatch = new SmartWatch();
		List<Product> products = List.of(mobilePhone, laptop, tablet, smartWatch);
		double totalCost = costCalculatorService.calculateCost(products);
		InvoiceGeneratorService invoiceGeneratorService = new InvoiceGeneratorService();
		invoiceGeneratorService.generateInvoice(totalCost);
	}
}
