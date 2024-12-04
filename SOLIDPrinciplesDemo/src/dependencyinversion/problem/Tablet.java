package dependencyinversion.problem;

public class Tablet implements AvailableProduct, RearCamera {
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

	@Override
	public void openRearCamera() {
		System.out.println("Rear camera open");
	}
}