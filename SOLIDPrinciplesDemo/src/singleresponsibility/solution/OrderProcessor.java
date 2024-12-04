package singleresponsibility.solution;

import java.util.List;

public class OrderProcessor {
	public static void main(String[] args) {
		CostCalculatorService costCalculatorService = new CostCalculatorService();
		MobilePhone mobilePhone = new MobilePhone(9800);
		Laptop laptop = new Laptop(54000);
		List<Object> products = List.of(mobilePhone, laptop);
		double totalCost = costCalculatorService.calculateCost(products);
		InvoiceGeneratorService invoiceGeneratorService = new InvoiceGeneratorService();
		invoiceGeneratorService.generateInvoice(totalCost);
	}
}
