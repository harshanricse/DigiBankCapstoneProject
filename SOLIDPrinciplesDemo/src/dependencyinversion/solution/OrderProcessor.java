package dependencyinversion.solution;

import java.util.List;

public class OrderProcessor {
	public static void main(String[] args) {
		ICostCalculatorService costCalculatorServiceRetail = new CostCalculatorServiceRetail();
		ICostCalculatorService costCalculatorServiceWholeSale = new CostCalculatorServiceWholeSale();
		AvailableProduct mobilePhone = new MobilePhone(9800);
		AvailableProduct laptop = new Laptop(54000);
		AvailableProduct tablet = new Tablet(15000);
		List<AvailableProduct> products = List.of(mobilePhone, laptop, tablet);

		InvoiceGeneratorService invoiceGeneratorService1 = new InvoiceGeneratorService(costCalculatorServiceRetail);
		invoiceGeneratorService1.generateInvoice(products);

		InvoiceGeneratorService invoiceGeneratorService2 = new InvoiceGeneratorService(costCalculatorServiceWholeSale);
		invoiceGeneratorService2.generateInvoice(products);
	}
}
