package dependencyinversion.problem;

import java.util.List;

public interface ICostCalculatorService {

	double calculateCost(List<AvailableProduct> products);
}
