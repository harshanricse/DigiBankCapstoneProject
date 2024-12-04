package liskovsubstitution.problem;

public class MobilePhone implements Product {

	static final int DISCOUNT = 6;
	private int cost;

	MobilePhone(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public double calculateCost() {
		return (double) cost * (100 - MobilePhone.DISCOUNT) / 100;
	}
}
