package liskovsubstitution.problem;

public class SmartWatch implements Product {

	@Override
	public double calculateCost() {
		throw new IllegalStateException("Product unavailable");
	}

}