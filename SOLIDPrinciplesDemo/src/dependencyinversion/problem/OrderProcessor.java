package dependencyinversion.problem;

import java.util.List;

public class OrderProcessor {
	public static void main(String[] args) {
		CostCalculatorService costCalculatorService = new CostCalculatorService();
		AvailableProduct mobilePhone = new MobilePhone(9800);
		AvailableProduct laptop = new Laptop(54000);
		AvailableProduct tablet = new Tablet(15000);
		List<AvailableProduct> products = List.of(mobilePhone, laptop, tablet);
		InvoiceGeneratorService invoiceGeneratorService = new InvoiceGeneratorService(costCalculatorService);
		invoiceGeneratorService.generateInvoice(products);
	}
}
