package dependencyinversion.problem;

import java.util.List;

public class InvoiceGeneratorService {

	CostCalculatorService costCalculatorService;

	InvoiceGeneratorService(CostCalculatorService costCalculatorService) {
		this.costCalculatorService = costCalculatorService;
	}

	public void generateInvoice(List<AvailableProduct> products) {
		System.out.println("Total cost of order = " + costCalculatorService.calculateCost(products));
	}
}
