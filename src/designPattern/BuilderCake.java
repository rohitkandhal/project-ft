package designPattern;


public class BuilderCake {
	
	private final double sugar; // cup
	private final double butter; // cup
	private final int eggs;
	private final double flour; // cup
	private final double milk;

	// Create static builder class within the class of which you need to create instance
	public static class Builder {

		// Repeat same fields
		private double sugar; // cup
		private double butter; // cup
		private int eggs;
		private double flour; // cup
		private double milk;

		public Builder sugar(double spoons) {
			this.sugar = spoons;
			return this;
		}

		public Builder butter(double cup) {
			this.butter = cup;
			return this;
		}

		public Builder eggs(int num) {
			this.eggs = num;
			return this;
		}

		public Builder flour(double cup) {
			this.flour = cup;
			return this;
		}

		public Builder milk(double cup) {
			this.milk = cup;
			return this;
		}

		public BuilderCake build() {
			return new BuilderCake(this);
		}
	}

	private BuilderCake(Builder builder) {
		this.sugar = builder.sugar;
		this.butter = builder.butter;
		this.eggs = builder.eggs;
		this.flour = builder.flour;
		this.milk = builder.milk;
	}

	@Override
	public String toString() {
		return "Cake{" + "sugar=" + sugar + ", butter=" + butter + ", eggs="
				+ eggs + ", flour=" + flour
				+ ", milk=" + milk +'}';

	}
	
}
