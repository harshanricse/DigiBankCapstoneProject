package dependencyinversion.solution;

import java.util.List;

public class InvoiceGeneratorService {

	final ICostCalculatorService costCalculatorService;

	InvoiceGeneratorService(ICostCalculatorService costCalculatorService) {
		this.costCalculatorService = costCalculatorService;
	}

	public void generateInvoice(List<AvailableProduct> products) {
		System.out.println("Total cost of order = " + costCalculatorService.calculateCost(products));
	}
}
