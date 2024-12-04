package liskovsubstitution.solution;

public class Tablet implements AvailableProduct {
	static final int DISCOUNT = 4;
	private int cost;

	Tablet(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public double calculateCost() {
		return (double) cost * (100 - Tablet.DISCOUNT) / 100;
	}
}