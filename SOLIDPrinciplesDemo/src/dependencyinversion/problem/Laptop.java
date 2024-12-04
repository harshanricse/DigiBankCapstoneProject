package dependencyinversion.problem;

public class Laptop implements AvailableProduct {
	static final int DISCOUNT = 5;
	private int cost;

	Laptop(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public double calculateCost() {
		return (double) cost * (100 - Laptop.DISCOUNT) / 100;
	}
}