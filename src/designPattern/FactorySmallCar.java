package designPattern;

public class FactorySmallCar extends FactoryCar {

	public FactorySmallCar() {
		super(FactoryCarType.SMALL);
		construct();
	}

	@Override
	protected void construct() {
		System.out.println("Building Small Car");
	}
}
