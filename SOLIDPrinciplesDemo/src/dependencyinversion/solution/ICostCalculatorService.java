package dependencyinversion.solution;

import java.util.List;

public interface ICostCalculatorService {

	double calculateCost(List<AvailableProduct> products);
}
