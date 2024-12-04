package singleresponsibility.problem;

public class Laptop {
	static final int DISCOUNT = 5;
	private int cost;

	Laptop(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}
}
